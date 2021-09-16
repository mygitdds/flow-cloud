DROP TABLE IF EXISTS `flow_project`;
CREATE TABLE `flow_project` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `flow_node`;
CREATE TABLE `flow_node` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` varchar(64)  NOT NULL DEFAULT '' COMMENT '项目ID',
  `type` varchar(100)  NOT NULL DEFAULT '' COMMENT '类型',
  `name` varchar(100)  NOT NULL DEFAULT '' COMMENT '名称',
  `left` varchar(100)  NOT NULL DEFAULT '' COMMENT '坐标',
  `top` varchar(100)  NOT NULL DEFAULT '' COMMENT '坐标',
  `ico` varchar(100)  NOT NULL DEFAULT '' COMMENT '图标',
  `responseData` varchar(2256)  NOT NULL DEFAULT '' COMMENT '接收参数',
  `requestData` varchar(2256)  NOT NULL DEFAULT '' COMMENT '输出参数',
  `state` varchar(100)  NOT NULL DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `flow_line`;
CREATE TABLE `flow_line` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` varchar(64)  NOT NULL DEFAULT '' COMMENT '项目ID',
  `from` BIGINT(20) NOT NULL DEFAULT '' COMMENT '开始节点ID',
  `to` BIGINT(20) NOT NULL DEFAULT '' COMMENT '结束节点ID',
  `label` varchar(256)  NOT NULL DEFAULT '' COMMENT '条件',
  PRIMARY KEY (`id`),
  unique  key  `uni_line`(`from`,`to`)
);

create table `flow_example`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` varchar(64)  NOT NULL DEFAULT '' COMMENT '项目ID',
  `node_now` BIGINT(20) NOT NULL DEFAULT '' COMMENT 'node_id',
  `context_param` text(2256)  NOT NULL DEFAULT '' COMMENT '参数',
)

CREATE TABLE `flow_node_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `project_id` varchar(64)  NOT NULL DEFAULT '' COMMENT '项目ID',
  `node_id` BIGINT(20) NOT NULL DEFAULT '' COMMENT 'node_id',
  `flow_example_id` BIGINT(20) NOT NULL DEFAULT '' COMMENT '流程实例id',
  `responseData` varchar(2256)  NOT NULL DEFAULT '' COMMENT '接收参数具体',
  `requestData` varchar(2256)  NOT NULL DEFAULT '' COMMENT '输出参数具体',
  `state` varchar(100)  NOT NULL DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `flow_node_data`;

CREATE TABLE `flow_node_data` (


)
