// Databricks notebook source

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "51d9a452-557b-49fe-8f64-638ae3f9eedf",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "training-scope", key = "dlssecret"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/9fa0a210-0a86-4f56-ae3e-71745656eb49/oauth2/token")

// COMMAND ----------

dbutils.fs.mount(
  source = "abfss://adftraining2container2@adftraining2storageacct2.dfs.core.windows.net/",
  mountPoint = "/mnt/data",
  extraConfigs = configs)

// COMMAND ----------

