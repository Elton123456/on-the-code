//这里有张 World 表 
//
// 
//+-----------------+------------+------------+--------------+---------------+
//| name            | continent  | area       | population   | gdp           |
//+-----------------+------------+------------+--------------+---------------+
//| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
//| Albania         | Europe     | 28748      | 2831741      | 12960000      |
//| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
//| Andorra         | Europe     | 468        | 78115        | 3712000       |
//| Angola          | Africa     | 1246700    | 20609294     | 100990000     |
//+-----------------+------------+------------+--------------+---------------+
// 
//
// 如果一个国家的面积超过 300 万平方公里，或者人口超过 2500 万，那么这个国家就是大国家。 
//
// 编写一个 SQL 查询，输出表中所有大国家的名称、人口和面积。 
//
// 例如，根据上表，我们应该输出: 
//
// 
//+--------------+-------------+--------------+
//| name         | population  | area         |
//+--------------+-------------+--------------+
//| Afghanistan  | 25500100    | 652230       |
//| Algeria      | 37100000    | 2381741      |
//+--------------+-------------+--------------+
// 
// 👍 144 👎 0


//There is no code of Java type for this problem
SELECT name,population,area from World where area > 3000000 or population > 25000000;

//SQL Schema
//DROP TABLE if exists World;
//create table World(name varchar(255),continent varchar(255),area int,population int,gdp int);
//insert into World(name,continent,area,population,gdp) values ( 'Afghanistan', 'Asia', '652230', '25500100', '203430000'),
//        ('Albania', 'Europe', '28748', '2831741', '129600000' ),
//        ('Algeria', 'Africa', '2381741', '37100000', '1886810000'),
//        ('Andorra', 'Europe', '468', '78115', '37120000'),
//        ('Angola', 'Africa', '1246700', '20609294', '1009900000');