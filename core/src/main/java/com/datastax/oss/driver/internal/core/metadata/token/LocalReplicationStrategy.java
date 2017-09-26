/*
 * Copyright (C) 2017-2017 DataStax Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.oss.driver.internal.core.metadata.token;

import com.datastax.oss.driver.api.core.metadata.Node;
import com.datastax.oss.driver.api.core.metadata.token.Token;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;
import java.util.List;
import java.util.Map;

class LocalReplicationStrategy implements ReplicationStrategy {

  @Override
  public SetMultimap<Token, Node> computeReplicasByToken(
      Map<Token, Node> tokenToPrimary, List<Token> ring) {
    ImmutableSetMultimap.Builder<Token, Node> result = ImmutableSetMultimap.builder();
    for (Map.Entry<Token, Node> entry : tokenToPrimary.entrySet()) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result.build();
  }
}
