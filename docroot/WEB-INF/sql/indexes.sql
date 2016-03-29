create index IX_2DD4B964 on DMDC_SHIP (shipid);

create index IX_FD4C40CD on DM_CERTIFICATE (CertificateCode);
create index IX_E289C825 on DM_CERTIFICATE (CertificateCode, CertificateName);

create index IX_E5554F29 on DM_GT_ORGANIZATION (OrganizationCode);

create index IX_9790A9E4 on DM_GT_REPORT_TEMPLATE (ReportCode);

create index IX_6B8DBA6C on DM_GT_ROUTE_CONFIG (RouteCode);

create index IX_F66E1905 on DM_HISTORY_ENTERPRISE (syncversion);

create index IX_F83D31C6 on DM_HISTORY_MINISTRY (MinistryCode);

create index IX_4B6E3317 on DM_HISTORY_STATE (syncversion);

create index IX_FDC7BA5B on DM_MINISTRY (MinistryCode);

create index IX_8909E07F on HISTORY_DMDC_SHIP (syncversion);

create index IX_4511E954 on HISTORY_SYNC_VERSION (id);
create index IX_CA0D4DE8 on HISTORY_SYNC_VERSION (syncversion);

create index IX_922BE1F9 on RESULT_DECLARATION (BusinessTypeCode);
create index IX_3A00F3DF on RESULT_DECLARATION (BusinessTypeCode, DocumentName, DocumentYear);
create index IX_C35704EE on RESULT_DECLARATION (RequestCode);

create index IX_D44CF2B9 on RESULT_NOTIFICATION (RequestCode);

create index IX_6EDA1525 on dm_history_enterprise (syncversion);

create index IX_1DEAD2D7 on dm_history_state (syncversion);

create index IX_5BB9B964 on dmdc_ship (shipid);

create index IX_A465505F on history_dmdc_ship (syncversion);

create index IX_396111E8 on history_sync_version (syncversion);

create index IX_E51539E1 on result_certificate (DocumentName, DocumentYear);
create index IX_B2137C73 on result_certificate (DocumentName, DocumentYear, CertificateCode);
create index IX_BD596F1A on result_certificate (DocumentName, DocumentYear, MaritimeCode);