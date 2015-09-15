package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.RoleDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.producer.dao.ProducerDAO;
import sg.edu.nus.iss.phoenix.producer.dao.impl.ProducerDAOImpl;
import sg.edu.nus.iss.phoenix.producer.entity.Producer;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.ProgramDAOImpl;
import sg.edu.nus.iss.phoenix.presenter.dao.PresenterDAO;
import sg.edu.nus.iss.phoenix.presenter.dao.impl.PresenterDAOImpl;

public class DAOFactoryImpl implements DAOFactory {
	private UserDao userDAO = new UserDaoImpl();
	private RoleDao roleDAO = new RoleDaoImpl();
	private ProgramDAO rpdao = new ProgramDAOImpl();
        private ProducerDAO pddao = new ProducerDAOImpl();
        private PresenterDAO prdao = new PresenterDAOImpl();


	@Override
	public UserDao getUserDAO() {
		// TODO Auto-generated method stub
		return userDAO;
	}

	@Override
	public RoleDao getRoleDAO() {
		// TODO Auto-generated method stub
		return roleDAO;
	}

	@Override
	public ProgramDAO getProgramDAO() {
		// TODO Auto-generated method stub
		return rpdao;
	}
        @Override
        public ProducerDAO getProducerDAO() {
		// TODO Auto-generated method stub
		return pddao;
	}
        @Override
        public PresenterDAO getPresenterDAO(){
            return prdao;
        }

}
