---
title: 个人项目
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.30"

---

# 个人项目

Base URLs:

# Authentication

# TeachingAiSystem/ChoiceQuestionController

## POST 添加章节

POST /choiceTest/insertChapter

chapter:章节

> Body 请求参数

```json
{
  "id": 0,
  "subject": "string",
  "chapter": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Chapter](#schemachapter)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 添加知识点

POST /choiceTest/insertKnowledge

name:知识点名称
chapterName:章节名称
subjectName:学科名称

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "chapter": 0,
  "chapterName": "string",
  "subjectName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Knowledge](#schemaknowledge)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 添加选择题

POST /choiceTest/insertQuestion

question:题目
option1:选项A
option2:选项B
option3:选项C
option4:选项D
answer
analysis
subject
chapter
knowledge

> Body 请求参数

```json
{
  "id": 0,
  "question": "string",
  "option1": "string",
  "option2": "string",
  "option3": "string",
  "option4": "string",
  "answer": "string",
  "analysis": "string",
  "subject": "string",
  "chapter": "string",
  "knowledge": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[QuestionsText](#schemaquestionstext)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 添加错题(或重要的题不分对错)

POST /choiceTest/insertWrongQuestion

judge
questionId:不可更改的那个id
reply:学生的答案

> Body 请求参数

```json
{
  "id": 0,
  "judge": 0,
  "questionId": 0,
  "classroom": "string",
  "student_id": "string",
  "question": "string",
  "option1": "string",
  "option2": "string",
  "option3": "string",
  "option4": "string",
  "answer": "string",
  "analysis": "string",
  "subject": "string",
  "chapter": "string",
  "knowledge": "string",
  "reply": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[JudgeResult](#schemajudgeresult)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 批量添加错题

POST /choiceTest/insertWrongQuestions

将insertWrongQuestion中的所有参数看作一个类，再将类封装成一个list集合

> Body 请求参数

```json
[
  {
    "id": 0,
    "judge": 0,
    "questionId": 0,
    "classroom": "string",
    "student_id": "string",
    "question": "string",
    "option1": "string",
    "option2": "string",
    "option3": "string",
    "option4": "string",
    "answer": "string",
    "analysis": "string",
    "subject": "string",
    "chapter": "string",
    "knowledge": "string",
    "reply": "string"
  }
]
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[JudgeResult](#schemajudgeresult)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 添加历史题目

POST /choiceTest/insertPreviousQuestions

所需的参数同insertWrongQuestions一样

> Body 请求参数

```json
[
  {
    "id": 0,
    "judge": 0,
    "questionId": 0,
    "classroom": "string",
    "student_id": "string",
    "question": "string",
    "option1": "string",
    "option2": "string",
    "option3": "string",
    "option4": "string",
    "answer": "string",
    "analysis": "string",
    "subject": "string",
    "chapter": "string",
    "knowledge": "string",
    "reply": "string"
  }
]
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[JudgeResult](#schemajudgeresult)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 删除学科

GET /choiceTest/deleteSubject

subject:科目

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 删除章节

GET /choiceTest/deleteChapter

subject:名字
chapter:名字

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|chapter|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 删除小结

GET /choiceTest/deleteKnowledge

subject
chapter
knowledge

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|chapter|query|string| 是 |none|
|knowledge|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 删除题库中的题目

GET /choiceTest/deleteQuestion

先将所有题目按照subject、chapter和knowledge分类，用户点击那个就可以删除哪个，再将修改的题目id传回

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 删除错题

GET /choiceTest/deleteWrongQuestions

用法同deleteQuestion

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 清空某个学生的所有错题本中的错题

GET /choiceTest/deleteAllWrongAnswers

student_id:学号

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 清空某个学生的所有错题本中的题目，不分对错

GET /choiceTest/deleteAllImportantAnswers

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 清空某个学生所有的历史题目

GET /choiceTest/deleteAllPreviousAnswers

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 修改科目名称

POST /choiceTest/updateSubject

subject:科目
chapter:
knowledge:
先将所有科目和章节列到屏幕上用户点哪个就修改那个，最后将点击的那个的所有信息传递(subject, chapter, knowledge)

> Body 请求参数

```json
{
  "id": 0,
  "subject": "string",
  "chapter": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Chapter](#schemachapter)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 修改章节名称

POST /choiceTest/updateChapter

subject:
chapter:章节
knowledge:
用法同上

> Body 请求参数

```json
{
  "id": 0,
  "subject": "string",
  "chapter": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Chapter](#schemachapter)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 修改章节名称

POST /choiceTest/updateKnowledge

subject:
chapter:
knowledge:小结
用法同上

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "chapter": 0,
  "chapterName": "string",
  "subjectName": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Knowledge](#schemaknowledge)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## POST 修改题库中的选择题

POST /choiceTest/updateQuestion

question
option1
option2
option3
option4
answer
analysis
subject
chapter
knowledge
先将所有题目按照类别列到屏幕上用户点哪个就修改那个，最后将点击的那个的所有信息传递

> Body 请求参数

```json
{
  "id": 0,
  "question": "string",
  "option1": "string",
  "option2": "string",
  "option3": "string",
  "option4": "string",
  "answer": "string",
  "analysis": "string",
  "subject": "string",
  "chapter": "string",
  "knowledge": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[QuestionsText](#schemaquestionstext)| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 查询所有科目

GET /choiceTest/getAllSubject

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 获取所有章节

GET /choiceTest/getChapters

subject:章节所属科目
page:所在页码
num:每页的数量

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 查询知识点

GET /choiceTest/getKnowledge

subject
chapter

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|chapter|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 获取所有选择题

GET /choiceTest/getAllQuestion

page:
num:
用法同上

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 获取某科目的所有选择题

GET /choiceTest/getQuestionsBySubject

page:所在的页数
num:每页的题数

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 获取某章节所有选择题

GET /choiceTest/getQuestionsByChapter

chapter:章节
page:所在的页数
num:每页的题数

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|chapter|query|string| 是 |none|
|subject|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 获取某小结所有选择题

GET /choiceTest/getQuestionsByKnowledge

page:所在的页数
num:每页的题数

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|knowledge|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 通过题目的id查找选择题题

GET /choiceTest/getQuestionById

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 按科目查看某学生所有历史选择题

GET /choiceTest/getPreviousQuestions

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|student_id|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 按章节查看某学生的所有历史选择题

GET /choiceTest/getPreviousAnswers

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|student_id|query|string| 是 |none|
|chapter|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 按小结查看某学生的所有历史选择题

GET /choiceTest/getPreviousAnswersByKnowledge

subject
student_id
chapter
knowledge

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|student_id|query|string| 是 |none|
|chapter|query|string| 是 |none|
|knowledge|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 查看某学生错题本中某科目所有选择题

GET /choiceTest/getWrongAnswerBySubject

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|
|subject|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 查看某学生错题本中某章节所有选择题

GET /choiceTest/getWrongAnswersByChapter

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|
|subject|query|string| 是 |none|
|chapter|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET 按小结查看某学生错题本中的的所有选择题

GET /choiceTest/getWrongAnswersByKnowledge

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|student_id|query|string| 是 |none|
|subject|query|string| 是 |none|
|chapter|query|string| 是 |none|
|knowledge|query|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

## GET getQuestionsByList

GET /choiceTest/getQuestionsByList

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|list|query|array[integer]| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": "",
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[Result](#schemaresult)|

# 数据模型

<h2 id="tocS_Result">Result</h2>

<a id="schemaresult"></a>
<a id="schema_Result"></a>
<a id="tocSresult"></a>
<a id="tocsresult"></a>

```json
{
  "code": "string",
  "data": {},
  "msg": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|string|false|none||none|
|data|object|false|none||none|
|msg|string|false|none||none|

<h2 id="tocS_QuestionsText">QuestionsText</h2>

<a id="schemaquestionstext"></a>
<a id="schema_QuestionsText"></a>
<a id="tocSquestionstext"></a>
<a id="tocsquestionstext"></a>

```json
{
  "id": 0,
  "question": "string",
  "option1": "string",
  "option2": "string",
  "option3": "string",
  "option4": "string",
  "answer": "string",
  "analysis": "string",
  "subject": "string",
  "chapter": "string",
  "knowledge": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|question|string|false|none||none|
|option1|string|false|none||none|
|option2|string|false|none||none|
|option3|string|false|none||none|
|option4|string|false|none||none|
|answer|string|false|none||none|
|analysis|string|false|none||none|
|subject|string|false|none||none|
|chapter|string|false|none||none|
|knowledge|string|false|none||none|

<h2 id="tocS_JudgeResult">JudgeResult</h2>

<a id="schemajudgeresult"></a>
<a id="schema_JudgeResult"></a>
<a id="tocSjudgeresult"></a>
<a id="tocsjudgeresult"></a>

```json
{
  "id": 0,
  "judge": 0,
  "questionId": 0,
  "classroom": "string",
  "student_id": "string",
  "question": "string",
  "option1": "string",
  "option2": "string",
  "option3": "string",
  "option4": "string",
  "answer": "string",
  "analysis": "string",
  "subject": "string",
  "chapter": "string",
  "knowledge": "string",
  "reply": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|judge|integer|false|none||none|
|questionId|integer|false|none||none|
|classroom|string|false|none||none|
|student_id|string|false|none||none|
|question|string|false|none||none|
|option1|string|false|none||none|
|option2|string|false|none||none|
|option3|string|false|none||none|
|option4|string|false|none||none|
|answer|string|false|none||none|
|analysis|string|false|none||none|
|subject|string|false|none||none|
|chapter|string|false|none||none|
|knowledge|string|false|none||none|
|reply|string|false|none||none|

<h2 id="tocS_Chapter">Chapter</h2>

<a id="schemachapter"></a>
<a id="schema_Chapter"></a>
<a id="tocSchapter"></a>
<a id="tocschapter"></a>

```json
{
  "id": 0,
  "subject": "string",
  "chapter": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|subject|string|false|none||none|
|chapter|string|false|none||none|

<h2 id="tocS_Knowledge">Knowledge</h2>

<a id="schemaknowledge"></a>
<a id="schema_Knowledge"></a>
<a id="tocSknowledge"></a>
<a id="tocsknowledge"></a>

```json
{
  "id": 0,
  "name": "string",
  "chapter": 0,
  "chapterName": "string",
  "subjectName": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|name|string|false|none||none|
|chapter|integer|false|none||none|
|chapterName|string|false|none||none|
|subjectName|string|false|none||none|

