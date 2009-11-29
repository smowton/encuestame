/**
 * encuestame: system online surveys Copyright (C) 2009 encuestame Development
 * Team
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of version 3 of the GNU General Public License as published by the
 * Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.encuestame.core.service;

import org.encuestame.web.beans.commons.MessageSourceFactoryBean;

/**
 * Interface to Service Manager.
 *
 * @author Picado, Juan juan@encuestame.org
 * @since 26/04/2009 20:12:31
 * File name: $HeadURL:$
 * Revision: $Revision$
 * Last modified: $Date:$
 * Last modified by: $Author:$
 */
public interface IServiceManager {

    public DataService getDataService();
    public void setDataService(DataService dataService);
    public SurveyService getSurveyService();
    public void setSurveyService(SurveyService surveyService);
    public SecurityService getSecurityService();
    public void setSecurityService(SecurityService securityService);
    public ApplicationServices getApplicationServices();
    public void setApplicationServices(ApplicationServices applicationServices);
    public MessageSourceFactoryBean getMessageSource();
    public void setMessageSource(MessageSourceFactoryBean messageSource);
}
