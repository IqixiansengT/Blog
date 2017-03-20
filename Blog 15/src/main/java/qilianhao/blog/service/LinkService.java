package qilianhao.blog.service;

import java.util.List;
import java.util.Map;
import qilianhao.blog.entity.Link;


/**
 * ��������Service�ӿ�
 * @author Administrator
 *
 */
public interface LinkService {

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
	 * ����id��������ʵ��
	 * @param id
	 * @return
	 */
	public Link findById(Integer id);
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
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
}
