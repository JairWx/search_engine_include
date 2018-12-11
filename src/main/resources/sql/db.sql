create table blog_url (
`id` int(10) not null auto_increment comment 'ID',
`url` varchar(100) not null default '' comment 'URL',
`create_date_time` bigint(10) not null default 0 comment '创建时间',
`status` int(10) not null default 0 comment '状态',
primary key(`id`)
)comment '博客链接提交'

create table commit_batch (
`id` int(10) not null auto_increment comment 'ID',
`success` int(100) not null default 0 comment '成功个数',
`remain` int(10) not null default 0 comment '剩余',
`not_same_site` varchar(10) not null default 0 comment '不是站点的链接',
`search_engine_name` varchar(10) not null default '' comment '搜索引擎站点',
`create_date_time` bigint(10) not null default 0 comment '创建时间',
primary key(`id`)
)comment '提交批次记录'