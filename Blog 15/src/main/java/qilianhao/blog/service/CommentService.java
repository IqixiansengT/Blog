package qilianhao.blog.service;

import java.util.List;
import java.util.Map;

import qilianhao.blog.entity.Blog;
import qilianhao.blog.entity.Comment;
import qilianhao.blog.entity.Link;


/**
 * ����Service�ӿ�
 * @author Administrator
 *
 */
public interface CommentService {

	/**
	 * ��ѯ�û�������Ϣ
	 * @param map
	 * @return
	 */
	
	public List<Comment> list(Map<String,Object> map);
	/**
	 * ��ҳ��ѯ�û�������Ϣ
	 * @param map
	 * @return
	 */
	public List<Comment> listAdmin(Map<String,Object> map);
	/**
	 * ��ѯ�û����۴������Ϣ
	 * @param map
	 * @return
	 */
	public List<Comment> listReview(Map<String,Object> map);
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public int add(Comment comment);
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
	public Comment findById(Integer id);
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	/**
	 * ���������Ϣ
	 * @param comment
	 * @return
	 */
	public int update(Comment comment);
}
