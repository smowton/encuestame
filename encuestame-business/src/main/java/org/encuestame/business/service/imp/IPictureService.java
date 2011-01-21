/*
 ************************************************************************************
 * Copyright (C) 2001-2011 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.business.service.imp;

import org.encuestame.business.service.PictureService.PictureType;

/**
 * Description Class.
 * @author Picado, Juan juanATencuestame.org
 * @since Jan 16, 2011 4:12:57 PM
 * @version Id:
 */
public interface IPictureService {


    /**
     * Return real path folder for user account.
     * @return
     */
    String getAccountUserPicturePath(final String username);

    /**
     * Get Profile Picture.
     * @param id
     * @param username
     * @param pictureType
     * @return
     */
    byte[] getProfilePicture(
            final String id,
            final String username,
            final PictureType pictureType);
}