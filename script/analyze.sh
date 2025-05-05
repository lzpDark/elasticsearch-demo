curl -u elastic:123456 -X POST "http://localhost:9200/_analyze" -H 'Content-Type: application/json' -d'
{
 "text":"人体工学机械键盘",
 "analyzer": "ik_max_word"
}' | jq '.'