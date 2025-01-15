-- CREATE TABLE [имя таблицы] (
-- [имя колонки] [тип данных],
-- [имя колонки] [тип данных],
-- ...
-- );
CREATE TABLE IF NOT EXISTS Students (
  ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  Name TEXT NOT NULL,
  GroupName TEXT NOT NULL,
  Score
  INTEGER NOT NULL
 );


 --SELECT [список полей] FROM [имя таблицы] WHERE [условие];
 SELECT * FROM Students;
 SELECT * FROM Students WHERE ID > 3
 SELECT GroupName FROM Students WHERE ID = 2


 --INSERT INTO [имя таблицы] ([список полей через запятую]) VALUES ([список
 -- значений через запятую]);
 INSERT INTO Students (Name, GroupName, Score) VALUES ("Bob", "Tbz11", 80);

 UPDATE Students SET Score = 90 WHERE Name = "Bob";


 --DELETE FROM [имя таблицы] WHERE [условие];
 DELETE FROM Students WHERE ID = 0;