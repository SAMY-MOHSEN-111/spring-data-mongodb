# spring-data-mongodb

## 1. @Document(collection = "authors")
## 2. @Id
## 3. @Field
## 4. @Indexed(unique = true)
## 5. @Query(value = "{field:?0}", fields = "{field1:1, field2: 1, field3: 0}"
## 6. MongoTemplate

Query query = new Query(Criteria.where("key").is(value).and(...);
Update update = new Update
.set(key,value)
.set(key,value);
