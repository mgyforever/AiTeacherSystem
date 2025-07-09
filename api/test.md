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

# TeachingAiSystem/TestController

## POST 必须的参数:

POST /test/insertTest

String begin(year-month-day h:m:s)
String end(year-month-day h:m:s)
String classroom
String name
String subject
int[] question_id(每道题的id)
String teacher_id, int duration
<p>
例子:
{
"begin":"2025-1-1 21:24:30",
"end":"2025-1-1 21:25:30",
"classroom":"1",
"name":"1",
"subject":"Linux嵌入式开发",
"question_id":[
5, 6, 7
],
"teacher_id":"1",
"duration":"1"
}

> Body 请求参数

```json
{
  "id": 0,
  "test_id": "string",
  "begin": "string",
  "end": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "subject": "string",
  "chapter_id": [
    0
  ],
  "blank_chapter_id": [
    0
  ],
  "question_id": [
    0
  ],
  "blank_question_id": [
    0
  ],
  "question_grade": [
    0
  ],
  "knowledge_id": [
    0
  ],
  "blank_knowledge_id": [
    0
  ],
  "blank_question_grade": [
    0
  ],
  "teacher_name": "string",
  "teacher_id": "string",
  "question_text": "string",
  "grade_text": "string",
  "knowledge_text": "string",
  "duration": 0,
  "grade": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Test](#schematest)| 否 |none|

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

## POST 必须的参数:

POST /test/insertStudentGrade

String test_id(试卷的id)
String test_name
String time(考试开始时间)
String classroom
String student_id
String name(学生姓名)
judge_questions{
String question_id(每道题的id)
int grade(每道题的分数)
int type(0为选择， 1为填空)
String answer(学生答案)
}
<p>
例子:
{
"test_id":"2a3d695b-6392-4d1f-be89-fdf71f03b506",
"Test-name":"1",
"time":"2025-01-01 21:24:30",
"classroom":"1",
"student_id":"20243067",
"name":"张三",
"judge_questions":[
{
"question_id":"5",
"grade":"1",
"type":"0",
"answer":"C"
},
{
"question_id":"6",
"grade":"1",
"type":"0",
"answer":"B"
},
{
"question_id":"7",
"grade":"1",
"type":"0",
"answer":"B"
}
]
}

> Body 请求参数

```json
{
  "id": 0,
  "test_id": "string",
  "test_name": "string",
  "time": "string",
  "classroom": "string",
  "student_id": "string",
  "name": "string",
  "grade": 0,
  "judge_questions": [
    {
      "question_id": 0,
      "grade": 0,
      "type": 0,
      "judge": 0,
      "answer": "string"
    }
  ]
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[StudentTest](#schemastudenttest)| 否 |none|

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

## POST 添加考试正确率

POST /test/insertTestRate

String test_id
String year:年级
String classroom
String nameL:考试名称
String subject
int[] chapter_id
int[] knowledge_id

> Body 请求参数

```json
{
  "id": 0,
  "test_id": "string",
  "begin": "string",
  "end": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "subject": "string",
  "chapter_id": [
    0
  ],
  "blank_chapter_id": [
    0
  ],
  "question_id": [
    0
  ],
  "blank_question_id": [
    0
  ],
  "question_grade": [
    0
  ],
  "knowledge_id": [
    0
  ],
  "blank_knowledge_id": [
    0
  ],
  "blank_question_grade": [
    0
  ],
  "teacher_name": "string",
  "teacher_id": "string",
  "question_text": "string",
  "grade_text": "string",
  "knowledge_text": "string",
  "duration": 0,
  "grade": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Test](#schematest)| 否 |none|

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

## GET id为自动增加的id

GET /test/deleteTest

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

## GET deleteGrade

GET /test/deleteGrade

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

## POST 必须的参数:

POST /test/updateTest

String begin(year-month-day h:m:s):考试开始时间
String end(year-month-day h:m:s):考试结束时间
String classroom
String name
String subject
int[] question_id:每道题的id
String teacher_id
String question_text
int duration:考试持续时间(分钟)
<p>
例子:
{
"id":10,
"begin":"2025-01-01 21:24:30",
"classroom":"1",
"name":"2",
"teacher_id":"1",
"duration":"1",
"end":"2025-1-1 21:25:30",
"subject":"Linux嵌入式开发",
"question_id":[
5, 6, 7
]
}

> Body 请求参数

```json
{
  "id": 0,
  "test_id": "string",
  "begin": "string",
  "end": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "subject": "string",
  "chapter_id": [
    0
  ],
  "blank_chapter_id": [
    0
  ],
  "question_id": [
    0
  ],
  "blank_question_id": [
    0
  ],
  "question_grade": [
    0
  ],
  "knowledge_id": [
    0
  ],
  "blank_knowledge_id": [
    0
  ],
  "blank_question_grade": [
    0
  ],
  "teacher_name": "string",
  "teacher_id": "string",
  "question_text": "string",
  "grade_text": "string",
  "knowledge_text": "string",
  "duration": 0,
  "grade": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Test](#schematest)| 否 |none|

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

## POST 必须的参数:

POST /test/updateGrade

String subject
String classroom
String student_id
String name
int grade
<p>
例子:
{
    "id":11,
    "subject":"Linux嵌入式开发",
    "classroom":"1",
    "student_id":"1",
    "name":"张三",
    "grade":"3"
}

> Body 请求参数

```json
{
  "id": 0,
  "test_id": "string",
  "subject": "string",
  "classroom": "string",
  "student_id": "string",
  "name": "string",
  "time": "string",
  "grade": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[TestGrade](#schematestgrade)| 否 |none|

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

## GET page:当前页码

GET /test/getAllTest

num:每页题的数量

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

## GET getTestById

GET /test/getTestById

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

## GET getTestByClassroom

GET /test/getTestByClassroom

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|classroom|query|string| 是 |none|

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

## GET getTestByTeacher_id

GET /test/getTestByTeacher_id

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|teacher_id|query|integer| 是 |none|

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

## GET getTestByTime

GET /test/getTestByTime

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|time|query|string| 是 |none|

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

## GET time:考试开始时间

GET /test/getTestsByTimeAndClassroom

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|time|query|string| 是 |none|
|classroom|query|string| 是 |none|

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

## GET getGradeByTestId

GET /test/getGradeByTestId

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|test_id|query|string| 是 |none|

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

## GET getGradeByClassroom

GET /test/getGradeByClassroom

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|classroom|query|string| 是 |none|

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

## GET getGradeBySubject

GET /test/getGradeBySubject

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

## GET getGradeBySubject

GET /test/getGradeBySubjectAndClassroom

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|subject|query|string| 是 |none|
|classroom|query|string| 是 |none|

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

## GET getStudentKnowledgeRate

GET /test/getStudentKnowledgeRate

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
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

## GET getTestRate

GET /test/getTestChapterRate

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|test_id|query|string| 是 |none|

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

## GET getTestKnowledgeRate

GET /test/getTestKnowledgeRate

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|test_id|query|string| 是 |none|

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

<h2 id="tocS_Test">Test</h2>

<a id="schematest"></a>
<a id="schema_Test"></a>
<a id="tocStest"></a>
<a id="tocstest"></a>

```json
{
  "id": 0,
  "test_id": "string",
  "begin": "string",
  "end": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "subject": "string",
  "chapter_id": [
    0
  ],
  "blank_chapter_id": [
    0
  ],
  "question_id": [
    0
  ],
  "blank_question_id": [
    0
  ],
  "question_grade": [
    0
  ],
  "knowledge_id": [
    0
  ],
  "blank_knowledge_id": [
    0
  ],
  "blank_question_grade": [
    0
  ],
  "teacher_name": "string",
  "teacher_id": "string",
  "question_text": "string",
  "grade_text": "string",
  "knowledge_text": "string",
  "duration": 0,
  "grade": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||必须的参数:<br />String begin(year-month-day h:m:s), String end(year-month-day h:m:s), String classroom, String name<br />, String subject, int[] question_id, String teacher_id, int duration|
|test_id|string|false|none||不传|
|begin|string|false|none||格式为year-month-day h:m:s|
|end|string|false|none||格式为year-month-day h:m:s|
|year|string|false|none||none|
|classroom|string|false|none||none|
|name|string|false|none||none|
|subject|string|false|none||none|
|chapter_id|[integer]|false|none||none|
|blank_chapter_id|[integer]|false|none||none|
|question_id|[integer]|false|none||none|
|blank_question_id|[integer]|false|none||none|
|question_grade|[number]|false|none||none|
|knowledge_id|[integer]|false|none||none|
|blank_knowledge_id|[integer]|false|none||none|
|blank_question_grade|[number]|false|none||none|
|teacher_name|string|false|none||不用传|
|teacher_id|string|false|none||none|
|question_text|string|false|none||none|
|grade_text|string|false|none||none|
|knowledge_text|string|false|none||不传|
|duration|integer|false|none||none|
|grade|number|false|none||none|

<h2 id="tocS_JudgeQuestions">JudgeQuestions</h2>

<a id="schemajudgequestions"></a>
<a id="schema_JudgeQuestions"></a>
<a id="tocSjudgequestions"></a>
<a id="tocsjudgequestions"></a>

```json
{
  "question_id": 0,
  "grade": 0,
  "type": 0,
  "judge": 0,
  "answer": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|question_id|integer|false|none||none|
|grade|number|false|none||none|
|type|integer|false|none||0为选择， 1为填空|
|judge|integer|false|none||前端不用传|
|answer|string|false|none||none|

<h2 id="tocS_StudentTest">StudentTest</h2>

<a id="schemastudenttest"></a>
<a id="schema_StudentTest"></a>
<a id="tocSstudenttest"></a>
<a id="tocsstudenttest"></a>

```json
{
  "id": 0,
  "test_id": "string",
  "test_name": "string",
  "time": "string",
  "classroom": "string",
  "student_id": "string",
  "name": "string",
  "grade": 0,
  "judge_questions": [
    {
      "question_id": 0,
      "grade": 0,
      "type": 0,
      "judge": 0,
      "answer": "string"
    }
  ]
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|test_id|string|false|none||none|
|test_name|string|false|none||none|
|time|string|false|none||none|
|classroom|string|false|none||none|
|student_id|string|false|none||none|
|name|string|false|none||none|
|grade|number|false|none||none|
|judge_questions|[[JudgeQuestions](#schemajudgequestions)]|false|none||none|

<h2 id="tocS_TestGrade">TestGrade</h2>

<a id="schematestgrade"></a>
<a id="schema_TestGrade"></a>
<a id="tocStestgrade"></a>
<a id="tocstestgrade"></a>

```json
{
  "id": 0,
  "test_id": "string",
  "subject": "string",
  "classroom": "string",
  "student_id": "string",
  "name": "string",
  "time": "string",
  "grade": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|test_id|string|false|none||none|
|subject|string|false|none||none|
|classroom|string|false|none||none|
|student_id|string|false|none||none|
|name|string|false|none||none|
|time|string|false|none||none|
|grade|number|false|none||none|

