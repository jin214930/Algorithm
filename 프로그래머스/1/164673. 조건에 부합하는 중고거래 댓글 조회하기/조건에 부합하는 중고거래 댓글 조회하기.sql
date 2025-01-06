SELECT TITLE, B.BOARD_ID, REPLY_ID, B.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM USED_GOODS_BOARD B JOIN USED_GOODS_REPLY R ON B.BOARD_ID = R.BOARD_ID
WHERE DATE_FORMAT(B.CREATED_DATE, "%Y-%m") = '2022-10'
ORDER BY R.CREATED_DATE, TITLE