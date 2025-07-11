package com.ccut.teachingaisystem.service.impl.mysql;

import com.ccut.teachingaisystem.domain.source.mysql.MCQ;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordWriter {

    // 确保文件夹存在的方法
    public static void createDirectories(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs(); // 创建多级目录
        }
    }

    // 将选择题列表写入到指定的 Word 文件
    public static void writeMCQsToWord(List<MCQ> mcqs, String filePath) throws IOException {
        // 确保目标文件夹存在
        createDirectories(new File(filePath).getParent());

        // 创建一个 XWPFDocument 对象，表示 Word 文档
        XWPFDocument document = new XWPFDocument();

        // 写入标题
        XWPFParagraph titleParagraph = document.createParagraph();
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("选择题汇总");
        titleRun.setBold(true);
        titleRun.setFontSize(16);

        // 遍历 MCQ 列表，逐一写入每道选择题
        for (MCQ mcq : mcqs) {
            // 添加题目
            XWPFParagraph questionParagraph = document.createParagraph();
            XWPFRun questionRun = questionParagraph.createRun();
            questionRun.setText(mcq.getQuestion());
            questionRun.setFontSize(12);
            questionRun.addBreak();

            // 添加选项
            XWPFParagraph optionsParagraph = document.createParagraph();
            optionsParagraph.setStyle("List Number");

            XWPFRun optionRun1 = optionsParagraph.createRun();
            optionRun1.setText("A. " + mcq.getOption1());
            optionRun1.addBreak();
            XWPFRun optionRun2 = optionsParagraph.createRun();
            optionRun2.setText("B. " + mcq.getOption2());
            optionRun2.addBreak();
            XWPFRun optionRun3 = optionsParagraph.createRun();
            optionRun3.setText("C. " + mcq.getOption3());
            optionRun3.addBreak();
            XWPFRun optionRun4 = optionsParagraph.createRun();
            optionRun4.setText("D. " + mcq.getOption4());
            optionRun4.addBreak();

            // 添加答案
            XWPFParagraph answerParagraph = document.createParagraph();
            XWPFRun answerRun = answerParagraph.createRun();
            answerRun.setText("【答案】" + mcq.getAnswer());
            answerRun.addBreak();

            // 添加解析
            XWPFParagraph analysisParagraph = document.createParagraph();
            XWPFRun analysisRun = analysisParagraph.createRun();
            analysisRun.setText("【解析】" + mcq.getAnalysis());
            analysisRun.addBreak();
        }

        // 将文档写入文件
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
        } finally {
            document.close();
        }
    }

    public static void main(String[] args) {
        try {
            // 这里是示例数据，可以在外部传递数据
            List<MCQ> mcqs = List.of(
                    new MCQ("1. 在x → 0+ 时，下列无穷小量中与 x 等价的是", "e-sin x - 1", "x + 1 - cos x", "1 - cos x", "x", "C", "e-sin x - 1 ~ -sin x ~ -x A 不对..."),
                    new MCQ("2. 已知函数 et", "A. x = 0 是 f(x) 的极值点，也是 g(x) 的极值点", "B. x = 0 是 f(x) 的极值点，(0, 0) 是曲线y = g(x) 的拐点", "C. x = 0 是 f(x) 的极值点，(0, 0) 是曲线y = f(x) 的拐点", "D. (0, 0) 是曲线 y = f(x) 的拐点，(0, 0) 也是曲线 y = g(x) 的拐点", "B", "f'(x), f''(x) 计算得到答案...")
            );
            // 调用外部方法生成 Word 文件
            writeMCQsToWord(mcqs, "D:\\java\\code\\TeachingAISystem\\src\\main\\resources\\mysql\\choice.docx");
            System.out.println("Word 文件生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


