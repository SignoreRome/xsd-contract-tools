# AGENTS.md

## Project
Multi-module Maven repo with two Maven plugins:
- xsd-splitter-maven-plugin (goal: split)
- proto-postprocess-maven-plugin (goal: rename-messages)

This repo is tooling for generating/maintaining the adapter contract (.proto) from a one-time XSD snapshot.

## Project structure
- /pom.xml: parent aggregator POM (no src/ in root).
- /xsd-splitter-maven-plugin: Maven plugin that splits one big schema.xsd into domain XSDs + common.xsd.
- /proto-postprocess-maven-plugin: Maven plugin that post-processes generated .proto files (rename messages to *Proto, etc.).
- /it: Maven invoker integration tests (added later).
- All generated files must go under target/ (never commit generated output).

## Build / Test
- Build all: ./mvnw clean verify  (Windows: mvnw.cmd clean verify)
- Fast local: ./mvnw -DskipTests clean install
- Build only plugins: ./mvnw -DskipTests -pl xsd-splitter-maven-plugin,proto-postprocess-maven-plugin -am clean install

## Run goals locally
- Split XSD:
  ./mvnw <groupId>:xsd-splitter-maven-plugin:<ver>:split -DinputXsd=... -DdomainsConfig=...
- Rename messages:
  ./mvnw <groupId>:proto-postprocess-maven-plugin:<ver>:rename-messages -DinputDir=... -DoutputDir=... -Dsuffix=Proto

## Proto style
- Field names must be lower_snake_case.
- Message names must be TitleCase and must end with 'Proto' (ReqProto, AnsProto, etc.).
- Avoid breaking changes: do not reuse field numbers; reserve removed tags.

## Always
- Keep changes small and focused (avoid repo-wide refactors).
- Prefer atomic commits (one logical change per commit).
- Run ./mvnw clean verify before finalizing a task.
- Update or add tests when behavior changes.
- Print the exact commands you ran and the resulting output (shortened if long).

## Ask first
- Adding new dependencies.
- Changing Java release version or Maven Wrapper version.
- Changing plugin goal names (@Mojo name) or coordinates (groupId/artifactId).
- Changing CI configuration.
- Changing proto contract rules (naming, field numbering policy).

## Never
- Commit secrets (tokens/keys/passwords).
- Commit generated build output (target/, generated artifacts).
- Push to remote automatically.
- Make breaking changes to .proto without explicit approval.

## DoD checklist (before commit)
- ./mvnw clean verify is green.
- No generated output staged (target/, .idea/, etc.).
- No new deps unless approved.
- Changes are minimal and task-scoped.
- Tests updated/added if behavior changed.

## Commit policy
After completing a task:
1) Run: ./mvnw clean verify
2) Show: git status and git diff
3) Stage: git add -A
4) Commit: git commit -m "<scope>: <short summary>"
5) Never push automatically.