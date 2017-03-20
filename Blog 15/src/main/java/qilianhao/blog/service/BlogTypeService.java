package qilianhao.blog.service;

import java.util.List;
import java.util.Map;

import qilianhao.blog.entity.BlogType;
import qilianhao.blog.entity.Link;


/**
 * ��������Service�ӿ�
 * @author Administrator
 *
 */
public interface BlogTypeService {

	/**
	 * ��ѯ���в������ͣ��Լ���Ӧ�Ĳ�������
	 * @return
	 */
	public List<BlogType> countList();
	
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
	 * ͨ��id���Ҳ�������ʵ��
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
	/**
	 * ���²��������Ϣ
	 * @param blogType
	 * @return
	 */
	public Integer update(BlogType blogType);
}
