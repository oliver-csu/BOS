INSERT INTO `t_user` VALUES ('1', 'oliver', '81dc9bdb52d04dc20036dbd8313ed055', null, null, null, null, null, null);

INSERT INTO `bc_staff` VALUES ('402840815bf0da5b015bf0db0b370000', '张三', '15705102215', '1', '0', '苏州分部', '10-20公斤');
INSERT INTO `bc_staff` VALUES ('402840815c01bcaf015c01be0f540000', '李四', '15705102215', '1', '0', '北京分部', '10-20公斤');

INSERT INTO `bc_decidedzone` VALUES ('123', '朝阳', '402840815c01bcaf015c01be0f540000');

INSERT INTO `bc_subarea` VALUES ('402840815c05a29f015c05a39bd80000', '123', 'QY003', '朝阳区', '1', '100', '0', '朝阳大道');
INSERT INTO `bc_subarea` VALUES ('402840815c14d135015c14d633560000', '123', 'QY004', '丰台区', '1', '100', '0', '丰台区');

INSERT INTO `auth_function` VALUES ('11', NULL, '基础档案', 'jichudangan', NULL, NULL, '1', 0);
INSERT INTO `auth_function` VALUES ('112', '11', '收派标准', 'standard', NULL, 'page_base_standard.action', '1', 1);
INSERT INTO `auth_function` VALUES ('113', '11', '取派员设置', 'staff', NULL, 'page_base_staff.action', '1', 2);
INSERT INTO `auth_function` VALUES ('114', '11', '区域设置', 'region', NULL, 'page_base_region.action', '1', 3);
INSERT INTO `auth_function` VALUES ('115', '11', '管理分区', 'subarea', NULL, 'page_base_subarea.action', '1', 4);
INSERT INTO `auth_function` VALUES ('116', '11', '管理定区/调度排班', 'decidedzone', NULL, 'page_base_decidedzone.action', '1', 5);
INSERT INTO `auth_function` VALUES ('12', NULL, '受理', 'shouli', NULL, NULL, '1', 1);
INSERT INTO `auth_function` VALUES ('121', '12', '业务受理', 'noticebill', NULL, 'page_qupai_noticebill_add.action', '1', 0);
INSERT INTO `auth_function` VALUES ('122', '12', '工作单快速录入', 'quickworkordermanage', NULL, 'page_qupai_quickworkorder.action', '1', 1);
INSERT INTO `auth_function` VALUES ('124', '12', '工作单导入', 'workordermanageimport', NULL, 'page_qupai_workorderimport.action', '1', 3);
INSERT INTO `auth_function` VALUES ('13', NULL, '调度', 'diaodu', NULL, NULL, '1', 2);
INSERT INTO `auth_function` VALUES ('131', '13', '查台转单', 'changestaff', NULL, NULL, '1', 0);
INSERT INTO `auth_function` VALUES ('132', '13', '人工调度', 'personalassign', NULL, 'page_qupai_diaodu.action', '1', 1);
INSERT INTO `auth_function` VALUES ('14', NULL, '物流配送流程管理', 'zhongzhuan', NULL, NULL, '1', 3);
INSERT INTO `auth_function` VALUES ('141', '14', '启动配送流程', 'start', NULL, 'workOrderManageAction_list.action', '1', 0);
INSERT INTO `auth_function` VALUES ('142', '14', '查看个人任务', 'personaltask', NULL, 'taskAction_findPersonalTask.action', '1', 1);
INSERT INTO `auth_function` VALUES ('143', '14', '查看我的组任务', 'grouptask', NULL, 'taskAction_findGroupTask.action', '1', 2);
INSERT INTO `auth_function` VALUES ('144', '113', '删除取派员', 'staff.delete', 'xxx', 'staffAction_delete.action', '0', 1);