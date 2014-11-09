/*
 * Copyright 2014 ncedu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ncedu.core.data.factories;

import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.factories.impl.LocalDAOFactory;
import ru.ncedu.core.data.factories.impl.OracleDAOFactory;

/**
 * Abstract class DAO Factory.
 * 
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public abstract class DAOFactory {

    // There will be a method for each DAO that can be 
    // created. The concrete factories will have to 
    // implement these methods.
    public abstract UserDAO getUserDAO();

    public abstract GroupDAO getGroupDAO();

    public static DAOFactory getDAOFactory(DAOType daoType) {
        switch (daoType) {
            case LOCAL:
                return new LocalDAOFactory();
            case ORACLE:
                return new OracleDAOFactory();
            default:
                throw new UnsupportedOperationException("Unsupported DAO type");
        }
    }

    /**
     * List of DAO types supported by the factory.
     */
    public enum DAOType {
        LOCAL,
        ORACLE;
    }

}
