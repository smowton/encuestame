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
package org.encuestame.utils.web;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.encuestame.utils.enums.CommentOptions;
import org.encuestame.utils.enums.TypeSearchResult;

/**
 * Unit Comment bean.
 * @author Morales, Diana Paola paolaATencuestame.org
 * @since August 14, 2011
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentBean implements Serializable{

    /** Serial. **/
    private static final long serialVersionUID = 3553112539868437033L;

    /** **/
    @JsonProperty(value = "id")
    private Long commentId;

    /** **/
    @JsonProperty(value = "comment")
    private String comment;

    /** **/
    @JsonProperty(value = "created_at")
    private Date createdAt;

    /** **/
    @JsonProperty(value = "likeVote")
    private Long likeVote;

    /** **/
    @JsonProperty(value = "dislike_vote")
    private Long dislikeVote;

    /** **/
    @JsonProperty(value = "item_id")
    private Long id;


    /** Type of Comment */
    @JsonProperty(value = "type")
    private TypeSearchResult type;

    /** **/
    @JsonIgnore
    @JsonProperty(value = "uid")
    private Long userAccountId;

    /**
     * Comment url.
     */
    @JsonProperty(value = "url")
    private String commentUrl;

    /**
     * Commented By.
     */
    @JsonProperty(value = "commented_by")
    private String commentedBy;

    /**
     * Commented By.
     */
    @JsonProperty(value = "commented_username")
    private String commentedByUsername;

    /** **/
    @JsonProperty(value = "parent_id")
    private Long parentId;

    @JsonProperty(value = "comment_status")
    private CommentOptions status;

    /**
     * @return the commentId
     */
    @JsonIgnore
    public Long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setCommentId(final Long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return the comment
     */
    @JsonIgnore
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * @return the createdAt
     */
    @JsonIgnore
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the likeVote
     */
    @JsonIgnore
    public Long getLikeVote() {
        return likeVote;
    }

    /**
     * @param likeVote the likeVote to set
     */
    public void setLikeVote(final Long likeVote) {
        this.likeVote = likeVote;
    }

    /**
     * @return the unlikeVote
     */
    @JsonIgnore
    public Long getDislikeVote() {
        return dislikeVote;
    }

    /**
     * @param unlikeVote the unlikeVote to set
     */
    public void setDislikeVote(final Long dislikeVote) {
        this.dislikeVote = dislikeVote;
    }

    /**
     * @return the userAccountId
     */
    @JsonIgnore
    public Long getUserAccountId() {
        return userAccountId;
    }

    /**
     * @param userAccountId the userAccountId to set
     */
    public void setUserAccountId(final Long userAccountId) {
        this.userAccountId = userAccountId;
    }


    /**
     * @return the parentId
     */
    @JsonIgnore
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(final Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the id
     */
    @JsonIgnore
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    @JsonIgnore
    public TypeSearchResult getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final TypeSearchResult type) {
        this.type = type;
    }

    /**
     * @return the commentedBy
     */
    @JsonIgnore
    public String getCommentedBy() {
        return commentedBy;
    }

    /**
     * @param commentedBy the commentedBy to set
     */
    public void setCommentedBy(final String commentedBy) {
        this.commentedBy = commentedBy;
    }

    /**
     * @return the commentedByUsername
     */
    @JsonIgnore
    public String getCommentedByUsername() {
        return commentedByUsername;
    }

    /**
     * @return the commentUrl
     */
    @JsonIgnore
    public String getCommentUrl() {
        return commentUrl;
    }

    /**
     * @param commentUrl the commentUrl to set
     */
    public void setCommentUrl(String commentUrl) {
        this.commentUrl = commentUrl;
    }

    /**
     * @param commentedByUsername the commentedByUsername to set
     */
    public void setCommentedByUsername(final String commentedByUsername) {
        this.commentedByUsername = commentedByUsername;
    }

	/**
	 * @return the status
	 */
	public CommentOptions getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(CommentOptions status) {
		this.status = status;
	}

    public char taintField;
    
}
