curl -X POST "localhost:9200/products/_doc" -H 'Content-Type: application/json' -d'
{
  "productId": "1",
  "name": "笔记本电脑",
  "description": "高性能轻薄笔记本电脑",
  "brand": "ThinkPad",
  "category": "电子产品",
  "price": 6999.00,
  "stock": 100,
  "tags": ["轻薄", "高性能"],
  "created_at": "2023-10-27 10:00:00"
}'

curl -X POST "localhost:9200/products/_doc" -H 'Content-Type: application/json' -d'
{
  "productId": "2",
  "name": "机械键盘",
  "description": "人体工学机械键盘",
  "brand": "Cherry",
  "category": "外设",
  "price": 899.00,
  "stock": 50,
  "tags": ["机械键盘", "人体工学"],
  "created_at": "2023-10-26 14:30:00"
}'

curl -X POST "localhost:9200/products/_bulk" -H 'Content-Type: application/x-ndjson' -d'
{"index":{"_id":"3"}}
{"productId": "3", "name": "无线鼠标", "description": "高精度无线鼠标", "brand": "Logitech", "category": "外设", "price": 199.00, "stock": 200, "tags": ["无线", "高精度"], "created_at": "2023-10-25 09:00:00"}
{"index":{"_id":"4"}}
{"productId": "4", "name": "显示器", "description": "4K高清显示器", "brand": "Dell", "category": "外设", "price": 3999.00, "stock": 30, "tags": ["4K", "高清"], "created_at": "2023-10-24 16:00:00"}
'
