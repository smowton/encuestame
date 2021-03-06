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

package org.encuestame.mvc.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.encuestame.mvc.controller.AbstractBaseOperations;
import org.encuestame.mvc.controller.AbstractViewController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Survey controller.
 * @author Picado, Juan juanATencuestame.org
 * @since Mar 11, 2010 9:21:55 PM
 */
@Controller
public class SurveyController  extends AbstractViewController {

    /**
     * Log.
     */
    private Log log = LogFactory.getLog(this.getClass());

            /**
             * Survey Controller.
             * @param model model
             * @return template
             */

    @PreAuthorize("hasRole('ENCUESTAME_USER')")
    @RequestMapping(value = "/user/survey", method = RequestMethod.GET)
    public String surveyController(final ModelMap model) {
         model.addAttribute("survey", "survey" );
        log.debug("survey");
        setCss(model, "survey");
        return "user/survey";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/survey/{id}/{slug}/", method = RequestMethod.GET)
    public String surveyPublicController(final ModelMap model,
            @PathVariable Long id,
            @PathVariable String slug) {
        log.debug("survey");
        setCss(model, "survey");
        return "survey";
    }
}
