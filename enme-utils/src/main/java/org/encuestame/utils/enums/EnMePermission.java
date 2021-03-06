/*
 ************************************************************************************
 * Copyright (C) 2001-2011 encuestame: system online surveys Copyright (C) 2011
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.utils.enums;

/**
 * Encuestame Global Permissions
 * @author Picado, Juan juanATencuestame.org
 * @since Oct 3, 2010 4:14:05 PM
 */
public enum EnMePermission {
    ENCUESTAME_USER("ENCUESTAME_USER"),
    ENCUESTAME_ADMIN("ENCUESTAME_ADMIN"),
    ENCUESTAME_OWNER("ENCUESTAME_OWNER"),
    ENCUESTAME_PUBLISHER("ENCUESTAME_PUBLISHER"),
    ENCUESTAME_EDITOR("ENCUESTAME_EDITOR"),
    ENCUESTAME_ANONYMOUS("ENCUESTAME_ANONYMOUS"),
    ENCUESTAME_API("ENCUESTAME_API"),
    ENCUESTAME_READ("ENCUESTAME_READ"),
    ENCUESTAME_WRITE("ENCUESTAME_WRITE");

    /**
     *
     */
    private String permissionAsString;

    /**
     *
     * @param permissionAsString
     */
    EnMePermission(String permissionAsString){
        this.permissionAsString = permissionAsString;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return this.permissionAsString;
    }
}
