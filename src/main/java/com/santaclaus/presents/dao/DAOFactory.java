package com.santaclaus.presents.dao;


public enum DAOFactory {
    
    INSTANCE;
    
    private PresentDAO presentDAO;
    private CandyDAO candyDAO;    

    public PresentDAO getPresentDAO(){
        if (presentDAO == null){
            presentDAO = new PresentDAOImpl();
        }
        return presentDAO;
    }

    public CandyDAO getCandyDAO() {
        if (candyDAO == null){
            candyDAO = new CandyDAOImpl();
        }
        return candyDAO;
    }
    
    
    
}
