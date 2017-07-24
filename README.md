# cognitect.anomalies

# Rationale

Anomalies capture errors as information that is simple, actionable,
generic, and extensible.

* Simple: Anomalies contain only information about the error, not
  e.g. flow control or causality.
* Actionable: the `::anom/category` aims to be a top-level
  partitioning of all kinds of errors, allowing many programs that need to
  branch during error-handling to branch *only* on this keyword.
* Generic: Anomalies are represented as ordinary maps, and can be created
  and consumed without any special API.
* Extensible: As maps are open, applications can add their own context
  via namespaced keywords. That said, try to do as much as possible
  by dispatching only via `::anom/category`.

Anomalies overlap in purpose with e.g. Java exceptions and HTTP
responses. The differences are instructive:

Java exceptions are not simple, as they combine error information with
a flow control mechanism. This is a problem in e.g. async applications
and transductions. Both of these contexts need to talk about errors,
but do not want to utilize exceptions' flow control by stack
unwinding.

HTTP responses provide useful partitioning via status codes. But since
status codes appear inside a server *response* they cannot possibly
cover e.g. failure to get a response at all.

# The Categories

The category column contains the name of an anomaly category within
the `cognitect.anomalies` namespace.

The retry column is "yes" if a replay of the same activity might
reasonably lead to a different outcome. When a program encounters a
retryable anomaly, it may be reasonable to back off and try again.

The "fix" column provides an example of how a programmer or operator
might fix problems in this category.

The "song" column contains a Hall and Oates song. The idea that Hall
and Oates are software gurus is controversial in some circles, so you
can treat this as flavortext.

| category | retry | fix | song |
| ---- | ---- | --- | --- |
| :unavailable | yes | make sure callee healthy | Out of Touch |
| :interrupted | yes | stop interrupting | It Doesn't Matter Anymore |
| :incorrect | no | fix caller bug | You'll Never Learn |
| :forbidden | no | fix caller creds | I Can't Go For That |
| :unsupported | no | fix caller verb | Your Imagination |
| :not-found | no | fix caller noun | She's Gone |
| :conflict | no | coordinate with callee | Give It Up |
| :fault | no | fix callee bug | Falling |
| :busy | yes | backoff and retry | Wait For Me |

# Using cognitect.anomalies

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

    [com.cognitect/anomalies "0.1.12"]

[Maven](http://maven.apache.org/) dependency information:

    <dependency>
      <groupId>com.cognitect</groupId>
      <artifactId>anomalies</artifactId>
      <version>0.1.12</version>
    </dependency>

# Developer Information

Please submit feedback via GitHub
[issues](https://github.com/cognitect-labs/anomalies/issues).

Please do not submit pull requests or patches.

# Copyright and License

Copyright (c) Cognitect, Inc.
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS-IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

