/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.persistence.api.dao;

import java.util.List;
import org.apache.syncope.common.lib.log.AuditEntry;
import org.apache.syncope.common.lib.types.AuditElements;
import org.apache.syncope.common.lib.types.LoggerType;
import org.apache.syncope.core.persistence.api.dao.search.OrderByClause;
import org.apache.syncope.core.persistence.api.entity.Logger;

public interface LoggerDAO extends DAO<Logger> {

    String AUDIT_TABLE = "SYNCOPEAUDIT";

    String AUDIT_MESSAGE_COLUMN = "MESSAGE";

    Logger find(String key);

    List<Logger> findAll(LoggerType type);

    Logger save(Logger logger);

    void delete(String key);

    void delete(Logger logger);

    List<AuditEntry> findAuditEntries(
            String entityKey,
            int page,
            int size,
            AuditElements.EventCategoryType type,
            String category,
            String subcategory,
            List<String> events,
            AuditElements.Result result,
            List<OrderByClause> orderByClauses);

    int countAuditEntries(String entityKey);
}
