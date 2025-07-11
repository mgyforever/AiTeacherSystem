package com.ccut.teachingaisystem.service.impl.mysql;

import com.ccut.teachingaisystem.domain.source.mysql.MCQ;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFParser {

    public static List<MCQ> parsePDF(String filePath) throws IOException {
        // 加载PDF文档
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper stripper = new PDFTextStripper();

        // 提取文本
        String text = stripper.getText(document);
        document.close();

        // 输出提取的文本（用于调试）
        System.out.println("PDF 内容提取成功，提取的文本如下：");
        System.out.println(text);

        // 调用方法解析提取的文本
        return parseTextToMCQs(text);
    }

    public static List<MCQ> parseTextToMCQs(String text) {
        List<MCQ> mcqs = new ArrayList<>();

        // 文本预处理：合并可能被错误分割的行（同一内容被分割到两行的情况）
        String processedText = text.replaceAll("([^\\n])\\n([^\\n])", "$1 $2");

        // 1. 题目匹配正则表达式：支持全角句号(．)和半角句号(.)，以及题目内容
        Pattern questionPattern = Pattern.compile("(\\d+)[．.](.*?)(?=\\d+[．.]|$)", Pattern.DOTALL);
        Matcher questionMatcher = questionPattern.matcher(processedText);

        while (questionMatcher.find()) {
            String questionNumber = questionMatcher.group(1);
            String questionContent = questionMatcher.group(2).trim();

            // 2. 提取选项：支持A. B. C. D. 格式，处理选项可能在同一行的情况
            Pattern optionPattern = Pattern.compile("([A-D])[．.]([^ABCD]+?)(?=[A-D][．.]|【答案】|$)", Pattern.DOTALL);
            Matcher optionMatcher = optionPattern.matcher(questionContent);

            String option1 = "", option2 = "", option3 = "", option4 = "";
            while (optionMatcher.find()) {
                String optChar = optionMatcher.group(1);
                String optContent = optionMatcher.group(2).trim().replaceAll("\\s+", " ");

                switch (optChar) {
                    case "A": option1 = optContent; break;
                    case "B": option2 = optContent; break;
                    case "C": option3 = optContent; break;
                    case "D": option4 = optContent; break;
                }
            }

            // 3. 提取答案：支持【答案】X格式
            Pattern answerPattern = Pattern.compile("【答案】([ABCD])");
            Matcher answerMatcher = answerPattern.matcher(questionContent);
            String answer = answerMatcher.find() ? answerMatcher.group(1) : "";

            // 4. 提取解析：支持【解析】后的内容，直到下一题或文档结束
            Pattern analysisPattern = Pattern.compile("【解析】(.*?)(?=\\d+[．.]|$)", Pattern.DOTALL);
            Matcher analysisMatcher = analysisPattern.matcher(processedText.substring(questionMatcher.end()));
            String analysis = analysisMatcher.find() ? analysisMatcher.group(1).trim().replaceAll("\\s+", " ") : "";

            // 创建MCQ对象并添加到列表
            mcqs.add(new MCQ(
                    questionNumber + ". " + questionContent.replaceAll("([A-D][．.].*?)(?=[A-D][．.]|【答案】)", "").trim(),
                    option1, option2, option3, option4, answer, analysis
            ));
        }

        return mcqs;
    }

    public static void main(String[] args) {
        try {
            List<MCQ> mcqs = parsePDF("D:\\java\\code\\TeachingAISystem\\src\\main\\resources\\mysql\\choice.pdf");
            for (MCQ mcq : mcqs) {
                System.out.println(mcq);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


