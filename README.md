# queriform

SQL Formatter

before
```sql
SELECT
      a as
     aaa
    ,
     b
   as bbb, c as
      ccc FROM
    table
```

after
```sql
SELECT
  a as aaa,
  b as bbb,
  c as ccc
FROM
  table
```
