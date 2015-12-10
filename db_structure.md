# users #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| user\_id       | number   | unique, not null, autoincrement |
| email          | text     | unique, required, not null |
| password       | text     | required, not null         |
| group\_id      | number   | required, not null, foreign key (groups.group\_id) |
| first\_name    | text     |                            |
| last\_name     | text     |                            |
| register\_when | date     |                            |
| last\_login    | date     |                            |

# groups #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| group\_id      | number   | unique, not null, autoincrement |
| parent\_id     | number   | unique, not null, autoincrement |
| name           | text     | required, not null         |

# pages #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| page\_id       | number   | unique, not null, autoincrement |
| parent\_id     | number   | not null                   |
| title          | text     | required, not null         |
| content        | clob     |                            |
| created\_by    | number   | foreign key (users.user\_id)  |
| created\_when  | date     |                            |
| modified\_by   | number   | foreign key (users.user\_id)  |
| modified\_when | date     |                            |
| properties     | text     |                            |

# comments #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| comment\_id    | number   | unique, not null, autoincrement |
| page\_id       | number   | foreign key (pages.page\_id) |
| comment        | clob     |                            |
| created\_by    | number   | foreign key (users.user\_id)  |
| created\_when  | date     |                            |
| modified\_by   | number   | foreign key (users.user\_id)  |
| modified\_when | date     |                            |

# rights #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| group\_id      | number   | foreign key (groups.group\_id) |
| page\_id       | number   | foreign key (pages.page\_id) |
| read           | number   | 1 - allow, 0 - prohibit    |
| write          | number   | 1 - allow, 0 - prohibit    |

# attachments #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| attachment\_id | number   | unique, not null, autoincrement |
| page\_id       | number   | foreign key (pages.page\_id) |
| name           | text     |                            |
| filepath       | text     |                            |

# settings #

| **Field name** | **Type** | **Additional information** |
|:---------------|:---------|:---------------------------|
| name           | text     | unique, not null           |
| value          | text     |                            |