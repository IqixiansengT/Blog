package qilianhao.blog.dao;

import java.util.List;
import java.util.Map;

import qilianhao.blog.entity.BlogType;
import qilianhao.blog.entity.Link;


/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface BlogTypeDao {

	/**
	 * ��ѯ���в������ͣ��Լ���Ӧ�Ĳ�������
	 * @return
	 */
	public List<BlogType> countList();
	
	/**
	 * ͨ��id���Ҳ�������ʵ��
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
	
	/**
	 * ��ҳ��ѯ���������Ϣ
	 * @param map
	 * @return
	 */
	public List<BlogType> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);

	/**
	 * ��Ӳ��������Ϣ
	 * @param BlogType
	 * @return
	 */
	public Integer add(BlogType blogType);
	/**
	 * ɾ�����������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	/**
	 * ���²��������Ϣ
	 * @param blogType
	 * @return
	 */
	public Integer update(BlogType blogType);
}
