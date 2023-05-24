# drools
## drools API开发步骤
1. 获取KieServices
2. 获取KieContainer
3. KieSession
4. Insert fact
5. 触发规则
6. 关闭KieSession

# 规则同步相关问题
## 现有规则组成方式
```json
[
  {
    "name": "rule_name_1",
    "id": 123,
    "xxx": "xxx",
    "rule_content": "xxxxxx"
  },
  {
    "name": "rule_name_2",
    "id": 456,
    "xxx": "xxx",
    "rule_content": "yyyyyy"
  },
  {
    "name": "rule_name_3",
    "id": 789,
    "xxx": "xxx",
    "rule_content": "zzzzzz"
  }
]
```
其中 rule_content 由一组复杂且冗长的数学公式组成。