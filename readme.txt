1、三层架构开发的构建流程
	1.1 搭配开发环境
		导入工程所需要的包
		log4j
		beanutils
		jstl
		
	1.2创建保存工程的包
		cn.itcast.domain
		
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.service.impl
		cn.itcast.web.controller
		cn.itcast.web.ui
		cn.itcast.utils
		cn.itcast.test
		
		/WEB-INF/jsp
		
2、三层架构的开发顺序
	2.1 先开发需要封装数据实体的javabean
	2.2之后开发Dao也就是数据操作层
	2.3开发service层为web层提供服务