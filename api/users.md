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

# TeachingAiSystem/Users

## POST register

POST /users/register

> Body 请求参数

```json
{
  "id": 0,
  "student_id": "string",
  "userName": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string",
  "account": "string",
  "year": "string",
  "classroom": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[StudentUsers](#schemastudentusers)| 否 |none|

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

## POST registerIdentify

POST /users/registerIdentify

> Body 请求参数

```json
{
  "id": "string",
  "name": "string",
  "sex": "string",
  "age": 0,
  "judge": 0,
  "phoneNumber": "string",
  "IDNumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[UsersIdentify](#schemausersidentify)| 否 |none|

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

## POST login

POST /users/login

> Body 请求参数

```json
{
  "id": 0,
  "judge": 0,
  "age": 0,
  "student_id": "string",
  "teacher_id": "string",
  "userName": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string",
  "subject": "string",
  "account": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "sex": "string",
  "IDNumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[TempUsers](#schematempusers)| 否 |none|

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

## POST managerLogin

POST /users/managerLogin

> Body 请求参数

```json
{
  "id": 0,
  "userName": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[Managers](#schemamanagers)| 否 |none|

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

## POST downLoad

POST /users/downLoad

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|judge|query|integer| 是 |none|
|userId|query|string| 是 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 是 |none|

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

## GET upload

GET /users/upload

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## GET getByID

GET /users/getById

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST InsertUsersMessage

POST /users/insertStudentsMessage

> Body 请求参数

```json
"string"
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|string| 否 |none|

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

## POST InsertTeachersMessage

POST /users/insertTeachersMessage

> Body 请求参数

```json
"string"
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|string| 否 |none|

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

## GET selectAll

GET /users/getAll

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|judge|query|integer| 是 |none|

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

## GET getByID

GET /users/getByUserId

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## GET getTeachersBySubject

GET /users/getTeachersBySubject

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

## GET getStudentIdentify

GET /users/getUsersIdentify

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|judge|query|integer| 是 |none|
|/userId|query|string| 是 |none|

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

## GET selectAllIdentify

GET /users/getAllIdentify

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|judge|query|integer| 是 |none|

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

## GET selectAllClassroomIdentify

GET /users/getClassroomIdentify

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|judge|query|integer| 是 |none|
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

## GET deleteTeacherFile

GET /users/deleteTeacherFile

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

## POST delete

POST /users/delete

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user_id|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## GET deleteIdentify

GET /users/deleteIdentify

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|user_id|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST update

POST /users/updateUser_id

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|
|user_id|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST updateUsername

POST /users/updateUsername

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|
|username|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST updatePassword

POST /users/updatePassword

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|query|integer| 是 |none|
|username|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST updateUserIdentify

POST /users/updateUserIdentify

> Body 请求参数

```json
{
  "id": "string",
  "name": "string",
  "sex": "string",
  "age": 0,
  "judge": 0,
  "phoneNumber": "string",
  "IDNumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[UsersIdentify](#schemausersidentify)| 否 |none|

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

## POST updateUserEmail

POST /users/updateUserEmail

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|

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

## POST updateUserImage

POST /users/updateUserFile

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 是 |none|

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

## POST updateUsers

POST /users/updateUsers

> Body 请求参数

```json
{
  "id": 0,
  "judge": 0,
  "age": 0,
  "student_id": "string",
  "teacher_id": "string",
  "userName": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string",
  "subject": "string",
  "account": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "sex": "string",
  "IDNumber": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|[TempUsers](#schematempusers)| 否 |none|

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

# TeachingAiSystem/ImagesController

## GET getImage

GET /images/getUserImages

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|userId|query|string| 是 |none|
|judge|query|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "uri": {
    "string": ""
  },
  "url": "",
  "cleanedUrl": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|[ResponseEntityUrlResource](#schemaresponseentityurlresource)|

# TeachingAiSystem/BlankQuestionController

## POST 添加填空题

POST /blankQuestion/insertQuestion

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
|body|body|[BlankQuestionText](#schemablankquestiontext)| 否 |none|

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

POST /blankQuestion/insertWrongQuestion

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

POST /blankQuestion/insertWrongQuestions

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

POST /blankQuestion/insertPreviousQuestions

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

## GET 删除题库中的题目

GET /blankQuestion/deleteQuestion

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

GET /blankQuestion/deleteWrongQuestions

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

GET /blankQuestion/deleteAllWrongAnswers

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

GET /blankQuestion/deleteAllImportantAnswers

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

GET /blankQuestion/deleteAllPreviousAnswers

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

## POST 修改题库中的填空题

POST /blankQuestion/updateQuestion

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
|body|body|[BlankQuestionText](#schemablankquestiontext)| 否 |none|

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

## GET 获取所有填空题

GET /blankQuestion/getAllQuestion

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

## GET 获取某科目的所有填空题

GET /blankQuestion/getQuestionsBySubject

subject:科目
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

## GET 获取某章节所有填空题

GET /blankQuestion/getQuestionsByChapter

subject:科目
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

## GET 获取某小结所有填空题

GET /blankQuestion/getQuestionsByKnowledge

knowledge:小结
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

## GET 通过题目的id查找填空题题

GET /blankQuestion/getQuestionById

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

## GET 按科目查看某学生所有历史填空题

GET /blankQuestion/getPreviousQuestions

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

## GET 按章节查看某学生的所有历史填空题

GET /blankQuestion/getPreviousAnswers

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

## GET 按小结查看某学生的所有历史填空题

GET /blankQuestion/getPreviousAnswersByKnowledge

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

## GET 查看某学生错题本中某科目所有填空题

GET /blankQuestion/getWrongAnswerBySubject

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

## GET 查看某学生错题本中某章节所有填空题

GET /blankQuestion/getWrongAnswersByChapter

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

## GET 按小结查看某学生错题本中的的所有填空题

GET /blankQuestion/getWrongAnswersByKnowledge

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

GET /blankQuestion/getQuestionsByList

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

# TeachingAiSystem/AiController

## GET 获取ppt

GET /ai/getPPT

topic:ppt的主题
teacher_id:教师编号

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|topic|query|string| 是 |none|
|teacher_id|query|string| 是 |none|

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

## GET 学生端的建议

GET /ai/getStudentFeedback

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|studentId|query|string| 是 |none|
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

## GET 学生端的分析(历史题目的章节和小结的百分比)

GET /ai/getStudentPercent

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|studentId|query|string| 是 |none|
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

## GET getTeacherFeedback

GET /ai/getTeacherFeedback

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|teacher_id|query|string| 是 |none|

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

## GET getTeacherPercent

GET /ai/getTeacherPercent

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|teacher_id|query|string| 是 |none|

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

<h2 id="tocS_TempUsers">TempUsers</h2>

<a id="schematempusers"></a>
<a id="schema_TempUsers"></a>
<a id="tocStempusers"></a>
<a id="tocstempusers"></a>

```json
{
  "id": 0,
  "judge": 0,
  "age": 0,
  "student_id": "string",
  "teacher_id": "string",
  "userName": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string",
  "subject": "string",
  "account": "string",
  "year": "string",
  "classroom": "string",
  "name": "string",
  "sex": "string",
  "IDNumber": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|judge|integer|false|none||none|
|age|integer|false|none||none|
|student_id|string|false|none||none|
|teacher_id|string|false|none||none|
|userName|string|false|none||none|
|password|string|false|none||none|
|phoneNumber|string|false|none||none|
|email|string|false|none||none|
|subject|string|false|none||none|
|account|string|false|none||none|
|year|string|false|none||none|
|classroom|string|false|none||none|
|name|string|false|none||none|
|sex|string|false|none||none|
|IDNumber|string|false|none||none|

<h2 id="tocS_UsersIdentify">UsersIdentify</h2>

<a id="schemausersidentify"></a>
<a id="schema_UsersIdentify"></a>
<a id="tocSusersidentify"></a>
<a id="tocsusersidentify"></a>

```json
{
  "id": "string",
  "name": "string",
  "sex": "string",
  "age": 0,
  "judge": 0,
  "phoneNumber": "string",
  "IDNumber": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|string|false|none||none|
|name|string|false|none||none|
|sex|string|false|none||none|
|age|integer|false|none||none|
|judge|integer|false|none||none|
|phoneNumber|string|false|none||none|
|IDNumber|string|false|none||none|

<h2 id="tocS_URI">URI</h2>

<a id="schemauri"></a>
<a id="schema_URI"></a>
<a id="tocSuri"></a>
<a id="tocsuri"></a>

```json
{
  "string": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|string|string|false|none||The string form of this URI.|

<h2 id="tocS_ResponseEntityUrlResource">ResponseEntityUrlResource</h2>

<a id="schemaresponseentityurlresource"></a>
<a id="schema_ResponseEntityUrlResource"></a>
<a id="tocSresponseentityurlresource"></a>
<a id="tocsresponseentityurlresource"></a>

```json
{
  "uri": {
    "string": "string"
  },
  "url": "string",
  "cleanedUrl": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|uri|[URI](#schemauri)|false|none||none|
|url|string|false|none||none|
|cleanedUrl|string¦null|false|none||none|

<h2 id="tocS_StudentUsers">StudentUsers</h2>

<a id="schemastudentusers"></a>
<a id="schema_StudentUsers"></a>
<a id="tocSstudentusers"></a>
<a id="tocsstudentusers"></a>

```json
{
  "id": 0,
  "student_id": "string",
  "userName": "string",
  "password": "string",
  "phoneNumber": "string",
  "email": "string",
  "account": "string",
  "year": "string",
  "classroom": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|student_id|string|false|none||none|
|userName|string|false|none||none|
|password|string|false|none||none|
|phoneNumber|string|false|none||none|
|email|string|false|none||none|
|account|string|false|none||none|
|year|string|false|none||none|
|classroom|string|false|none||none|

<h2 id="tocS_Managers">Managers</h2>

<a id="schemamanagers"></a>
<a id="schema_Managers"></a>
<a id="tocSmanagers"></a>
<a id="tocsmanagers"></a>

```json
{
  "id": 0,
  "userName": "string",
  "password": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|false|none||none|
|userName|string|false|none||none|
|password|string|false|none||none|

<h2 id="tocS_BlankQuestionText">BlankQuestionText</h2>

<a id="schemablankquestiontext"></a>
<a id="schema_BlankQuestionText"></a>
<a id="tocSblankquestiontext"></a>
<a id="tocsblankquestiontext"></a>

```json
{
  "id": 0,
  "question": "string",
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
|answer|string|false|none||none|
|analysis|string|false|none||none|
|subject|string|false|none||none|
|chapter|string|false|none||none|
|knowledge|string|false|none||none|

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

