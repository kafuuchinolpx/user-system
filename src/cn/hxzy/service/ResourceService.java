package cn.hxzy.service;

import cn.hxzy.dao.ResourceDao;
import cn.hxzy.entity.Resource;

import java.util.Date;
import java.util.List;

public class ResourceService {
    ResourceDao resourceDao = new ResourceDao();

    public void add(Resource resource) throws Exception {
        resource.setCreateTime(new Date());
        resourceDao.add(resource);
    }

    public void update(Resource resource) throws Exception {
        resource.setUpdateTime(new Date());
        resourceDao.update(resource);
    }

    public void deleteById(int id) throws Exception {
        resourceDao.delete(id);
    }

    public List<Resource> findAll() throws Exception {
        List<Resource> list = resourceDao.findByPid(0);
        for (Resource resource : list) {
            resource.setSon(resourceDao.findByPid(resource.getId()));
        }
        return list;
    }

    public Resource findById(Integer id) throws Exception {
        return resourceDao.findById(id);
    }

    public List<Resource> findByRoleIdNotHave(int id) throws Exception {
        return resourceDao.findByRoleIdNotHave(id);
    }
}
