# CONTRIBUTING.md

## О проекте
Репозиторий содержит инструменты (Maven-плагины) для подготовки контрактов:
- `xsd-splitter-maven-plugin` — разрезает большой `schema.xsd` на доменные XSD + `common.xsd`.
- `proto-postprocess-maven-plugin` — пост-обработка `.proto` (например, переименование `message` в `*Proto`).