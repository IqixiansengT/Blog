package qilianhao.blog.dao;

import java.util.List;
import java.util.Map;

import qilianhao.blog.entity.Blog;
import qilianhao.blog.entity.Link;


/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface LinkDao {

	/**
	 * ��������������Ϣ
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public Link findById(Integer id);

	/**
	 * ���������Ϣ
	 * @param link
	 * @return
	 */
	public Integer add(Link link);
	/**
	 * ����������Ϣ
	 * @param link
	 * @return
	 */
	public Integer update(Link link);
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
