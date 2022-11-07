# hack
## Main.java
### getJson(String filePath)
引数で指定されたJsonファイルを読み取り、Json文字列を出力
### jsonToMap(String json)
引数のJson文字列をjavaオブジェクトに変換
### mapToJson(Object ob)
引数のjavaオブジェクトをJson文字列に変換
### outputJson(String json, String filePath)
引数のJson文字列を指定されたファイルに出力
### getTeacherData(List<Object> list)
javaオブジェクトに変換したJson文字列からTeacher型のデータリストを出力
### getStudentData(List<Object> list)
javaオブジェクトに変換したJson文字列からStudent型のデータリストを出力
### shapeData(List<Teacher> teachers, List<Student> students)
Teacher型のデータリストとStudent型のデータリストをプランナーで使いやすい文字列リストに変換
## Teacher.java
先生を表すクラス
## Student.java
生徒を表すクラス
