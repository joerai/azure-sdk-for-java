/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.servicebus.models;

import com.microsoft.windowsazure.core.LazyArrayList;

import java.util.ArrayList;
import java.util.Calendar;

public class ServiceBusTopic {
    private Calendar accessedAt;
    
    /**
    * Optional. The time the queue was last accessed.
    * @return The AccessedAt value.
    */
    public Calendar getAccessedAt() {
        return this.accessedAt;
    }
    
    /**
    * Optional. The time the queue was last accessed.
    * @param accessedAtValue The AccessedAt value.
    */
    public void setAccessedAt(final Calendar accessedAtValue) {
        this.accessedAt = accessedAtValue;
    }
    
    private ArrayList<ServiceBusSharedAccessAuthorizationRule> authorizationRules;
    
    /**
    * Optional. Gets the authorization rules for the description.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The AuthorizationRules value.
    */
    public ArrayList<ServiceBusSharedAccessAuthorizationRule> getAuthorizationRules() {
        return this.authorizationRules;
    }
    
    /**
    * Optional. Gets the authorization rules for the description.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param authorizationRulesValue The AuthorizationRules value.
    */
    public void setAuthorizationRules(final ArrayList<ServiceBusSharedAccessAuthorizationRule> authorizationRulesValue) {
        this.authorizationRules = authorizationRulesValue;
    }
    
    private String autoDeleteOnIdle;
    
    /**
    * Optional. Implemented.
    * @return The AutoDeleteOnIdle value.
    */
    public String getAutoDeleteOnIdle() {
        return this.autoDeleteOnIdle;
    }
    
    /**
    * Optional. Implemented.
    * @param autoDeleteOnIdleValue The AutoDeleteOnIdle value.
    */
    public void setAutoDeleteOnIdle(final String autoDeleteOnIdleValue) {
        this.autoDeleteOnIdle = autoDeleteOnIdleValue;
    }
    
    private CountDetails countDetails;
    
    /**
    * Optional. Current queue statistics.
    * @return The CountDetails value.
    */
    public CountDetails getCountDetails() {
        return this.countDetails;
    }
    
    /**
    * Optional. Current queue statistics.
    * @param countDetailsValue The CountDetails value.
    */
    public void setCountDetails(final CountDetails countDetailsValue) {
        this.countDetails = countDetailsValue;
    }
    
    private Calendar createdAt;
    
    /**
    * Optional. The time the queue was created at.
    * @return The CreatedAt value.
    */
    public Calendar getCreatedAt() {
        return this.createdAt;
    }
    
    /**
    * Optional. The time the queue was created at.
    * @param createdAtValue The CreatedAt value.
    */
    public void setCreatedAt(final Calendar createdAtValue) {
        this.createdAt = createdAtValue;
    }
    
    private String defaultMessageTimeToLive;
    
    /**
    * Optional. Determines how long a message lives in the associated
    * subscriptions. Subscriptions inherit the TTL from the topic unless they
    * are created explicitly with a smaller TTL. Based on whether
    * dead-lettering is enabled, a message whose TTL has expired will either
    * be moved to the subscription's associated DeadLtterQueue or will be
    * permanently deleted. The following values are settable at topic creation
    * time:* Range: 1 second - TimeSpan.MaxValue* Default: TimeSpan.MaxValue
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj839740.aspx
    * for more information)
    * @return The DefaultMessageTimeToLive value.
    */
    public String getDefaultMessageTimeToLive() {
        return this.defaultMessageTimeToLive;
    }
    
    /**
    * Optional. Determines how long a message lives in the associated
    * subscriptions. Subscriptions inherit the TTL from the topic unless they
    * are created explicitly with a smaller TTL. Based on whether
    * dead-lettering is enabled, a message whose TTL has expired will either
    * be moved to the subscription's associated DeadLtterQueue or will be
    * permanently deleted. The following values are settable at topic creation
    * time:* Range: 1 second - TimeSpan.MaxValue* Default: TimeSpan.MaxValue
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/jj839740.aspx
    * for more information)
    * @param defaultMessageTimeToLiveValue The DefaultMessageTimeToLive value.
    */
    public void setDefaultMessageTimeToLive(final String defaultMessageTimeToLiveValue) {
        this.defaultMessageTimeToLive = defaultMessageTimeToLiveValue;
    }
    
    private String duplicateDetectionHistoryTimeWindow;
    
    /**
    * Optional. Specifies the time span during which the Service Bus will
    * detect message duplication.* Range: 1 second - 7 days* Default: 10
    * minutes  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The DuplicateDetectionHistoryTimeWindow value.
    */
    public String getDuplicateDetectionHistoryTimeWindow() {
        return this.duplicateDetectionHistoryTimeWindow;
    }
    
    /**
    * Optional. Specifies the time span during which the Service Bus will
    * detect message duplication.* Range: 1 second - 7 days* Default: 10
    * minutes  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param duplicateDetectionHistoryTimeWindowValue The
    * DuplicateDetectionHistoryTimeWindow value.
    */
    public void setDuplicateDetectionHistoryTimeWindow(final String duplicateDetectionHistoryTimeWindowValue) {
        this.duplicateDetectionHistoryTimeWindow = duplicateDetectionHistoryTimeWindowValue;
    }
    
    private boolean enableBatchedOperations;
    
    /**
    * Optional. Enables or disables service side batching behavior when
    * performing operations for the specific queue. When enabled, service bus
    * will collect/batch multiple operations to the backend to be more
    * connection efficient. If user wants lower operation latency then they
    * can disable this feature.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The EnableBatchedOperations value.
    */
    public boolean isEnableBatchedOperations() {
        return this.enableBatchedOperations;
    }
    
    /**
    * Optional. Enables or disables service side batching behavior when
    * performing operations for the specific queue. When enabled, service bus
    * will collect/batch multiple operations to the backend to be more
    * connection efficient. If user wants lower operation latency then they
    * can disable this feature.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param enableBatchedOperationsValue The EnableBatchedOperations value.
    */
    public void setEnableBatchedOperations(final boolean enableBatchedOperationsValue) {
        this.enableBatchedOperations = enableBatchedOperationsValue;
    }
    
    private String entityAvailabilityStatus;
    
    /**
    * Optional. The current availability status of the topic.
    * @return The EntityAvailabilityStatus value.
    */
    public String getEntityAvailabilityStatus() {
        return this.entityAvailabilityStatus;
    }
    
    /**
    * Optional. The current availability status of the topic.
    * @param entityAvailabilityStatusValue The EntityAvailabilityStatus value.
    */
    public void setEntityAvailabilityStatus(final String entityAvailabilityStatusValue) {
        this.entityAvailabilityStatus = entityAvailabilityStatusValue;
    }
    
    private boolean filteringMessagesBeforePublishing;
    
    /**
    * Optional. Gets or sets whether messages should be filtered before
    * publishing.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The FilteringMessagesBeforePublishing value.
    */
    public boolean isFilteringMessagesBeforePublishing() {
        return this.filteringMessagesBeforePublishing;
    }
    
    /**
    * Optional. Gets or sets whether messages should be filtered before
    * publishing.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param filteringMessagesBeforePublishingValue The
    * FilteringMessagesBeforePublishing value.
    */
    public void setFilteringMessagesBeforePublishing(final boolean filteringMessagesBeforePublishingValue) {
        this.filteringMessagesBeforePublishing = filteringMessagesBeforePublishingValue;
    }
    
    private boolean isAnonymousAccessible;
    
    /**
    * Optional. Gets whether anonymous access is allowed.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The IsAnonymousAccessible value.
    */
    public boolean isAnonymousAccessible() {
        return this.isAnonymousAccessible;
    }
    
    /**
    * Optional. Gets whether anonymous access is allowed.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param isAnonymousAccessibleValue The IsAnonymousAccessible value.
    */
    public void setIsAnonymousAccessible(final boolean isAnonymousAccessibleValue) {
        this.isAnonymousAccessible = isAnonymousAccessibleValue;
    }
    
    private int maxSizeInMegabytes;
    
    /**
    * Optional. Specifies the maximum topic size in megabytes. Any attempt to
    * enqueue a message that will cause the topic to exceed this value will
    * fail. All messages that are stored in the topic or any of its
    * subscriptions count towards this value. Multiple copies of a message
    * that reside in one or multiple subscriptions count as a single messages.
    * For example, if message m exists once in subscription s1 and twice in
    * subscription s2, m is counted as a single message. You can only set this
    * parameter at topic creation time using the following values:* Range: 1 -
    * 5*1024 MB* Default: 1*1024  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The MaxSizeInMegabytes value.
    */
    public int getMaxSizeInMegabytes() {
        return this.maxSizeInMegabytes;
    }
    
    /**
    * Optional. Specifies the maximum topic size in megabytes. Any attempt to
    * enqueue a message that will cause the topic to exceed this value will
    * fail. All messages that are stored in the topic or any of its
    * subscriptions count towards this value. Multiple copies of a message
    * that reside in one or multiple subscriptions count as a single messages.
    * For example, if message m exists once in subscription s1 and twice in
    * subscription s2, m is counted as a single message. You can only set this
    * parameter at topic creation time using the following values:* Range: 1 -
    * 5*1024 MB* Default: 1*1024  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param maxSizeInMegabytesValue The MaxSizeInMegabytes value.
    */
    public void setMaxSizeInMegabytes(final int maxSizeInMegabytesValue) {
        this.maxSizeInMegabytes = maxSizeInMegabytesValue;
    }
    
    private String name;
    
    /**
    * Optional. The name of the topic.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Optional. The name of the topic.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private boolean requiresDuplicateDetection;
    
    /**
    * Optional. If enabled, the topic will detect duplicate messages within the
    * time span specified by the DuplicateDetectionHistoryTimeWindow property.
    * Settable only at topic creation time.* Default: false  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The RequiresDuplicateDetection value.
    */
    public boolean isRequiresDuplicateDetection() {
        return this.requiresDuplicateDetection;
    }
    
    /**
    * Optional. If enabled, the topic will detect duplicate messages within the
    * time span specified by the DuplicateDetectionHistoryTimeWindow property.
    * Settable only at topic creation time.* Default: false  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param requiresDuplicateDetectionValue The RequiresDuplicateDetection
    * value.
    */
    public void setRequiresDuplicateDetection(final boolean requiresDuplicateDetectionValue) {
        this.requiresDuplicateDetection = requiresDuplicateDetectionValue;
    }
    
    private int sizeInBytes;
    
    /**
    * Optional. Reflects the actual bytes toward the topic quota that messages
    * in the topic currently occupy. (read-only)* Range: 0
    * -MaxTopicSizeinMegaBytes  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The SizeInBytes value.
    */
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }
    
    /**
    * Optional. Reflects the actual bytes toward the topic quota that messages
    * in the topic currently occupy. (read-only)* Range: 0
    * -MaxTopicSizeinMegaBytes  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param sizeInBytesValue The SizeInBytes value.
    */
    public void setSizeInBytes(final int sizeInBytesValue) {
        this.sizeInBytes = sizeInBytesValue;
    }
    
    private String status;
    
    /**
    * Optional. Gets or sets the current status of the topic (enabled or
    * disabled). When a topic is disabled, that topic cannot send or receive
    * messages.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The Status value.
    */
    public String getStatus() {
        return this.status;
    }
    
    /**
    * Optional. Gets or sets the current status of the topic (enabled or
    * disabled). When a topic is disabled, that topic cannot send or receive
    * messages.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param statusValue The Status value.
    */
    public void setStatus(final String statusValue) {
        this.status = statusValue;
    }
    
    private int subscriptionCount;
    
    /**
    * Optional. The current number of subscriptions to the topic.
    * @return The SubscriptionCount value.
    */
    public int getSubscriptionCount() {
        return this.subscriptionCount;
    }
    
    /**
    * Optional. The current number of subscriptions to the topic.
    * @param subscriptionCountValue The SubscriptionCount value.
    */
    public void setSubscriptionCount(final int subscriptionCountValue) {
        this.subscriptionCount = subscriptionCountValue;
    }
    
    private boolean supportOrdering;
    
    /**
    * Optional. Gets or sets whether the topics can be ordered.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @return The SupportOrdering value.
    */
    public boolean isSupportOrdering() {
        return this.supportOrdering;
    }
    
    /**
    * Optional. Gets or sets whether the topics can be ordered.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/hh780749.aspx for
    * more information)
    * @param supportOrderingValue The SupportOrdering value.
    */
    public void setSupportOrdering(final boolean supportOrderingValue) {
        this.supportOrdering = supportOrderingValue;
    }
    
    private Calendar updatedAt;
    
    /**
    * Optional. The time the queue was last updated.
    * @return The UpdatedAt value.
    */
    public Calendar getUpdatedAt() {
        return this.updatedAt;
    }
    
    /**
    * Optional. The time the queue was last updated.
    * @param updatedAtValue The UpdatedAt value.
    */
    public void setUpdatedAt(final Calendar updatedAtValue) {
        this.updatedAt = updatedAtValue;
    }
    
    /**
    * Initializes a new instance of the ServiceBusTopic class.
    *
    */
    public ServiceBusTopic() {
        this.setAuthorizationRules(new LazyArrayList<ServiceBusSharedAccessAuthorizationRule>());
    }
}
