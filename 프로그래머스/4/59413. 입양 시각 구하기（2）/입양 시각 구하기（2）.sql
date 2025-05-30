-- 코드를 입력하세요
WITH RECURSIVE OUT_TIME AS (
    SELECT 0 HOUR
    UNION ALL
    SELECT HOUR + 1
    FROM OUT_TIME
    WHERE HOUR < 23
)
SELECT HOUR, COUNT(ANIMAL_ID)
FROM OUT_TIME O LEFT JOIN ANIMAL_OUTS A ON O.HOUR = HOUR(DATETIME)
GROUP BY HOUR
ORDER BY HOUR