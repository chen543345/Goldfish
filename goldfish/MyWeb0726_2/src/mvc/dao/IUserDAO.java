package mvc.dao;
import mvc.vo.User; //����mvc.vo�������User��
//��Ҫ��������Ľӿڣ�����һϵ�����ݿ��ԭ���Բ��������磺���ӡ��޸ġ�ɾ������ID��ѯ�ȣ�
public interface IUserDAO { 
        /** 
         * �û���¼��֤ 
         *@param user ����VO���� 
         *@param ��֤�Ĳ������ 
         *@throw Exception 
         */ 
    public boolean findLogin(User user)throws Exception; 
} 