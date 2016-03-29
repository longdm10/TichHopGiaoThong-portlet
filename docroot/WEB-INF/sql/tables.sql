create table CREW_LIST (
	ID LONG not null primary key,
	crewcode VARCHAR(75) null,
	documentno VARCHAR(75) null,
	statecode VARCHAR(75) null,
	birthday DATE null,
	birthplace VARCHAR(75) null,
	familyname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	givenname VARCHAR(75) null,
	passportnumber VARCHAR(75) null,
	passporttype VARCHAR(75) null,
	rankcode VARCHAR(75) null,
	createdate DATE null,
	modifydate DATE null
);

create table DMDC_SHIP (
	id LONG not null primary key,
	shipid INTEGER,
	shipname VARCHAR(75) null,
	shiptypeid INTEGER,
	shiptypecode VARCHAR(75) null,
	imo VARCHAR(75) null,
	callsign VARCHAR(75) null,
	stateid VARCHAR(75) null,
	statecode VARCHAR(75) null,
	registrynumber VARCHAR(75) null,
	registrydate DATE null,
	registryportid INTEGER,
	registryportcode VARCHAR(75) null,
	gt LONG,
	nrt LONG,
	dwt LONG,
	shiplength LONG,
	shipwidth LONG,
	shipheight LONG,
	sailingspeed LONG,
	color VARCHAR(75) null,
	bonecode VARCHAR(75) null,
	machinecode VARCHAR(75) null,
	shipagencyid INTEGER,
	shipagencycode VARCHAR(75) null,
	fishingboatregistration VARCHAR(75) null,
	roleship INTEGER,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table DM_CERTIFICATE (
	ID LONG not null primary key,
	CertificateCode VARCHAR(75) null,
	CertificateName VARCHAR(75) null,
	CertificateNameVN VARCHAR(75) null,
	CertificateOrder INTEGER,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_ENTERPRISE (
	id INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	enterprisetaxcode VARCHAR(75) null,
	enterprisename VARCHAR(75) null,
	enterpriseshortname VARCHAR(75) null,
	enterpriseforeignname VARCHAR(75) null,
	enterpriseperson VARCHAR(75) null,
	enterprisehoaddress VARCHAR(75) null,
	statecode VARCHAR(75) null,
	citycode VARCHAR(75) null,
	districtcode VARCHAR(75) null,
	wardcode VARCHAR(75) null,
	telephoneno VARCHAR(75) null,
	registrationcode VARCHAR(75) null,
	registrationaddress VARCHAR(75) null,
	registrationdate DATE null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null,
	modifieduser VARCHAR(75) null
);

create table DM_GT_ORGANIZATION (
	ID LONG not null primary key,
	OrganizationCode VARCHAR(75) null,
	OrganizationName VARCHAR(75) null,
	OrganizationNameVN VARCHAR(75) null,
	OrganizationOrder INTEGER,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_GT_REPORT_CATEGORY (
	ID LONG not null primary key,
	Category VARCHAR(75) null,
	CategoryName VARCHAR(75) null,
	CategoryOrder INTEGER,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_GT_REPORT_TEMPLATE (
	ID LONG not null primary key,
	ReportCode INTEGER,
	ReportName VARCHAR(75) null,
	ReportType INTEGER,
	Category VARCHAR(75) null,
	Description VARCHAR(75) null,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_GT_ROUTE_CONFIG (
	ID LONG not null primary key,
	RouteCode VARCHAR(75) null,
	OrganizationCode VARCHAR(75) null,
	LocCode VARCHAR(75) null,
	IPName VARCHAR(75) null,
	PortName VARCHAR(75) null,
	LinkAddress VARCHAR(75) null,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_HISTORY_ENTERPRISE (
	id INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	enterprisetaxcode VARCHAR(75) null,
	enterprisename VARCHAR(75) null,
	enterpriseshortname VARCHAR(75) null,
	enterpriseforeignname VARCHAR(75) null,
	enterpriseperson VARCHAR(75) null,
	enterprisehoaddress VARCHAR(75) null,
	statecode VARCHAR(75) null,
	citycode VARCHAR(75) null,
	districtcode VARCHAR(75) null,
	wardcode VARCHAR(75) null,
	telephoneno VARCHAR(75) null,
	registrationcode VARCHAR(75) null,
	registrationaddress VARCHAR(75) null,
	registrationdate DATE null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null,
	modifieduser VARCHAR(75) null
);

create table DM_HISTORY_MINISTRY (
	ID LONG not null primary key,
	MinistryCode VARCHAR(75) null,
	MinistryName VARCHAR(75) null,
	MinistryNameVN VARCHAR(75) null,
	MinistryOrder INTEGER,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_HISTORY_STATE (
	id INTEGER not null primary key,
	statecode VARCHAR(75) null,
	statename VARCHAR(75) null,
	description VARCHAR(75) null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table DM_MINISTRY (
	ID LONG not null primary key,
	MinistryCode VARCHAR(75) null,
	MinistryName VARCHAR(75) null,
	MinistryNameVN VARCHAR(75) null,
	MinistryOrder INTEGER,
	IsDelete INTEGER,
	MarkedAsDelete INTEGER,
	ModifiedDate DATE null,
	RequestedDate DATE null,
	SyncVersion VARCHAR(75) null
);

create table DM_STATE (
	id INTEGER not null primary key,
	statecode VARCHAR(75) null,
	statename VARCHAR(75) null,
	description VARCHAR(75) null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table DM_SYNC_CATEGORY (
	id LONG not null primary key,
	CategoryID VARCHAR(75) null,
	categorydescription VARCHAR(75) null,
	modifieduser VARCHAR(75) null,
	modifieddate DATE null
);

create table DM_TEST_N01_REQUEST (
	requestid INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	ten_du_an VARCHAR(75) null,
	su_can_thiet_dau_tu VARCHAR(75) null,
	vi_tri VARCHAR(75) null,
	loai_tau_bien_gioi_han_vao_cang VARCHAR(75) null,
	so_luong_cau_cang VARCHAR(75) null,
	tong_dien_tich_xay_dung_du_kien VARCHAR(75) null,
	tai_lieu_lien_quan VARCHAR(75) null,
	modifieddate DATE null,
	modifiedUser VARCHAR(75) null,
	isAuthorized INTEGER,
	authorizeddate DATE null,
	authorizeduser VARCHAR(75) null
);

create table DOCUMENT (
	ID LONG not null primary key,
	documentname VARCHAR(75) null,
	usercreated VARCHAR(75) null,
	documenttypecode VARCHAR(75) null,
	callsign VARCHAR(75) null,
	predocumentname VARCHAR(75) null,
	createddate DATE null,
	lastmodifieddate DATE null
);

create table DOCUMENT_GENERAL (
	id LONG not null primary key,
	documentno VARCHAR(75) null,
	documentfunction VARCHAR(75) null,
	isarrival INTEGER,
	isdeparture INTEGER,
	shipcode VARCHAR(75) null,
	arrivalordepartureportcode VARCHAR(75) null,
	timearrivalordeparture DATE null,
	imonumber VARCHAR(75) null,
	callsign VARCHAR(75) null,
	voyagenumber INTEGER,
	shipnationcode VARCHAR(75) null,
	nameofmaster VARCHAR(75) null,
	lastport VARCHAR(75) null,
	contactdetailshipagent VARCHAR(75) null,
	grosstonnage LONG,
	nettonnage LONG,
	positionshipinport INTEGER,
	briefparticularsvoyage VARCHAR(75) null,
	briefdescriptioncargo VARCHAR(75) null,
	crewnumber INTEGER,
	passengernumber INTEGER,
	remarks VARCHAR(75) null,
	cargodeclaration VARCHAR(75) null,
	shipstoresdeclaration VARCHAR(75) null,
	crewlist VARCHAR(75) null,
	passengerlist VARCHAR(75) null,
	shiprequirements VARCHAR(75) null,
	iscreweffectdeclaration INTEGER,
	ismaritimedeclarationhealth INTEGER,
	createdate DATE null,
	modifydate DATE null
);

create table HISTORY_DMDC_SHIP (
	id LONG not null primary key,
	shipid INTEGER,
	shipname VARCHAR(75) null,
	shiptypeid INTEGER,
	shiptypecode VARCHAR(75) null,
	imo VARCHAR(75) null,
	callsign VARCHAR(75) null,
	stateid VARCHAR(75) null,
	statecode VARCHAR(75) null,
	registrynumber VARCHAR(75) null,
	registrydate DATE null,
	registryportid INTEGER,
	registryportcode VARCHAR(75) null,
	gt LONG,
	nrt LONG,
	dwt LONG,
	ship_length LONG,
	ship_width LONG,
	ship_height LONG,
	sailingspeed LONG,
	color VARCHAR(75) null,
	bonecode VARCHAR(75) null,
	machinecode VARCHAR(75) null,
	shipagencyid INTEGER,
	shipagencycode VARCHAR(75) null,
	fishingboatregistration VARCHAR(75) null,
	roleship INTEGER,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table HISTORY_SYNC_VERSION (
	id LONG not null primary key,
	requesteddate DATE null,
	timeofpublish DATE null,
	categoryid VARCHAR(75) null,
	syncunit VARCHAR(75) null,
	syncuser VARCHAR(75) null,
	syncversion VARCHAR(75) null,
	latestvaluedate DATE null
);

create table Notice_Ship_Message (
	id LONG not null primary key,
	noticeshipcode VARCHAR(75) null,
	documentname VARCHAR(75) null,
	usercreated VARCHAR(75) null,
	confirmtime INTEGER,
	callsign VARCHAR(75) null,
	arrivaldate DATE null,
	arrivalportcode VARCHAR(75) null,
	portgoingtocode VARCHAR(75) null,
	nameandaddofshipowners VARCHAR(75) null,
	clearanceheight LONG,
	showndraft LONG,
	dwt LONG,
	shipagencycode VARCHAR(75) null,
	purposecode INTEGER,
	crewnumber LONG,
	passengernumber LONG,
	quantityandtypeofcargo VARCHAR(75) null,
	otherpersons INTEGER,
	remarks VARCHAR(75) null
);

create table PASSENGER_LIST (
	ID LONG not null primary key,
	passengercode VARCHAR(75) null,
	documentno VARCHAR(75) null,
	fullname VARCHAR(75) null,
	statecode VARCHAR(75) null,
	birthday DATE null,
	birthplace VARCHAR(75) null,
	passporttypecode VARCHAR(75) null,
	passportno VARCHAR(75) null,
	portcheckincode VARCHAR(75) null,
	portcheckoutcode VARCHAR(75) null,
	istransit BOOLEAN,
	createdate DATE null,
	modifydate DATE null
);

create table RESPONSEBO (
	id LONG not null primary key,
	issuccess INTEGER,
	errormessage VARCHAR(75) null
);

create table RESULT_DECLARATION (
	id LONG not null primary key,
	RequestCode VARCHAR(75) null,
	RequestState INTEGER,
	DocumentName LONG,
	DocumentYear INTEGER,
	BusinessOrder INTEGER,
	BusinessTypeCode INTEGER,
	LatestSend INTEGER,
	DeclarationTime DATE null,
	ArrivalDepartureTime DATE null,
	RemainingTime DATE null,
	Remarks VARCHAR(75) null
);

create table RESULT_NOTIFICATION (
	id LONG not null primary key,
	RequestCode VARCHAR(75) null,
	RequestState INTEGER,
	DocumentName LONG,
	DocumentYear INTEGER,
	MaritimeCode VARCHAR(75) null,
	Role INTEGER,
	Response INTEGER
);

create table crew_list (
	id LONG not null primary key,
	crewcode VARCHAR(75) null,
	documentno VARCHAR(75) null,
	statecode VARCHAR(75) null,
	birthday DATE null,
	birthplace VARCHAR(75) null,
	familyname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	givenname VARCHAR(75) null,
	passportnumber VARCHAR(75) null,
	passporttype VARCHAR(75) null,
	rankcode VARCHAR(75) null,
	createdate DATE null,
	modifydate DATE null
);

create table dm_enterprise (
	id INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	enterprisetaxcode VARCHAR(75) null,
	enterprisename VARCHAR(75) null,
	enterpriseshortname VARCHAR(75) null,
	enterpriseforeignname VARCHAR(75) null,
	enterpriseperson VARCHAR(75) null,
	enterprisehoaddress VARCHAR(75) null,
	statecode VARCHAR(75) null,
	citycode VARCHAR(75) null,
	districtcode VARCHAR(75) null,
	wardcode VARCHAR(75) null,
	telephoneno VARCHAR(75) null,
	registrationcode VARCHAR(75) null,
	registrationaddress VARCHAR(75) null,
	registrationdate DATE null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null,
	modifieduser VARCHAR(75) null
);

create table dm_history_enterprise (
	id INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	enterprisetaxcode VARCHAR(75) null,
	enterprisename VARCHAR(75) null,
	enterpriseshortname VARCHAR(75) null,
	enterpriseforeignname VARCHAR(75) null,
	enterpriseperson VARCHAR(75) null,
	enterprisehoaddress VARCHAR(75) null,
	statecode VARCHAR(75) null,
	citycode VARCHAR(75) null,
	districtcode VARCHAR(75) null,
	wardcode VARCHAR(75) null,
	telephoneno VARCHAR(75) null,
	registrationcode VARCHAR(75) null,
	registrationaddress VARCHAR(75) null,
	registrationdate DATE null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null,
	modifieduser VARCHAR(75) null
);

create table dm_history_state (
	id INTEGER not null primary key,
	statecode VARCHAR(75) null,
	statename VARCHAR(75) null,
	description VARCHAR(75) null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table dm_state (
	id INTEGER not null primary key,
	statecode VARCHAR(75) null,
	statename VARCHAR(75) null,
	description VARCHAR(75) null,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table dm_sync_category (
	id LONG not null primary key,
	CategoryID VARCHAR(75) null,
	categorydescription VARCHAR(75) null,
	modifieduser VARCHAR(75) null,
	modifieddate DATE null
);

create table dm_test_n01_request (
	requestid INTEGER not null primary key,
	enterprisecode VARCHAR(75) null,
	ten_du_an VARCHAR(75) null,
	su_can_thiet_dau_tu VARCHAR(75) null,
	vi_tri VARCHAR(75) null,
	loai_tau_bien_gioi_han_vao_cang VARCHAR(75) null,
	so_luong_cau_cang VARCHAR(75) null,
	tong_dien_tich_xay_dung_du_kien VARCHAR(75) null,
	tai_lieu_lien_quan VARCHAR(75) null,
	modifieddate DATE null,
	modifiedUser VARCHAR(75) null,
	isAuthorized INTEGER,
	authorizeddate DATE null,
	authorizeduser VARCHAR(75) null
);

create table dmdc_ship (
	id LONG not null primary key,
	shipid INTEGER,
	shipname VARCHAR(75) null,
	shiptypeid INTEGER,
	shiptypecode VARCHAR(75) null,
	imo VARCHAR(75) null,
	callsign VARCHAR(75) null,
	stateid VARCHAR(75) null,
	statecode VARCHAR(75) null,
	registrynumber VARCHAR(75) null,
	registrydate DATE null,
	registryportid INTEGER,
	registryportcode VARCHAR(75) null,
	gt LONG,
	nrt LONG,
	dwt LONG,
	shiplength LONG,
	shipwidth LONG,
	shipheight LONG,
	sailingspeed LONG,
	color VARCHAR(75) null,
	bonecode VARCHAR(75) null,
	machinecode VARCHAR(75) null,
	shipagencyid INTEGER,
	shipagencycode VARCHAR(75) null,
	fishingboatregistration VARCHAR(75) null,
	roleship INTEGER,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table document (
	id LONG not null primary key,
	documentname VARCHAR(75) null,
	usercreated VARCHAR(75) null,
	documenttypecode VARCHAR(75) null,
	callsign VARCHAR(75) null,
	predocumentname VARCHAR(75) null,
	createddate DATE null,
	lastmodifieddate DATE null
);

create table document_general (
	id LONG not null primary key,
	documentno VARCHAR(75) null,
	documentfunction VARCHAR(75) null,
	isarrival INTEGER,
	isdeparture INTEGER,
	shipcode VARCHAR(75) null,
	arrivalordepartureportcode VARCHAR(75) null,
	timearrivalordeparture DATE null,
	imonumber VARCHAR(75) null,
	callsign VARCHAR(75) null,
	voyagenumber INTEGER,
	shipnationcode VARCHAR(75) null,
	nameofmaster VARCHAR(75) null,
	lastport VARCHAR(75) null,
	contactdetailshipagent VARCHAR(75) null,
	grosstonnage LONG,
	nettonnage LONG,
	positionshipinport INTEGER,
	briefparticularsvoyage VARCHAR(75) null,
	briefdescriptioncargo VARCHAR(75) null,
	crewnumber INTEGER,
	passengernumber INTEGER,
	remarks VARCHAR(75) null,
	cargodeclaration VARCHAR(75) null,
	shipstoresdeclaration VARCHAR(75) null,
	crewlist VARCHAR(75) null,
	passengerlist VARCHAR(75) null,
	shiprequirements VARCHAR(75) null,
	iscreweffectdeclaration INTEGER,
	ismaritimedeclarationhealth INTEGER,
	createdate DATE null,
	modifydate DATE null
);

create table history_dmdc_ship (
	id LONG not null primary key,
	shipid INTEGER,
	shipname VARCHAR(75) null,
	shiptypeid INTEGER,
	shiptypecode VARCHAR(75) null,
	imo VARCHAR(75) null,
	callsign VARCHAR(75) null,
	stateid VARCHAR(75) null,
	statecode VARCHAR(75) null,
	registrynumber VARCHAR(75) null,
	registrydate DATE null,
	registryportid INTEGER,
	registryportcode VARCHAR(75) null,
	gt LONG,
	nrt LONG,
	dwt LONG,
	ship_length LONG,
	ship_width LONG,
	ship_height LONG,
	sailingspeed LONG,
	color VARCHAR(75) null,
	bonecode VARCHAR(75) null,
	machinecode VARCHAR(75) null,
	shipagencyid INTEGER,
	shipagencycode VARCHAR(75) null,
	fishingboatregistration VARCHAR(75) null,
	roleship INTEGER,
	isdelete INTEGER,
	markedasdelete INTEGER,
	modifieddate DATE null,
	requesteddate DATE null,
	syncversion VARCHAR(75) null
);

create table history_sync_version (
	id LONG not null primary key,
	requesteddate DATE null,
	timeofpublish DATE null,
	categoryid VARCHAR(75) null,
	syncunit VARCHAR(75) null,
	syncuser VARCHAR(75) null,
	syncversion VARCHAR(75) null,
	latestvaluedate DATE null
);

create table notice_ship_message (
	id LONG not null primary key,
	noticeshipcode VARCHAR(75) null,
	documentname VARCHAR(75) null,
	usercreated VARCHAR(75) null,
	confirmtime INTEGER,
	callsign VARCHAR(75) null,
	arrivaldate DATE null,
	arrivalportcode VARCHAR(75) null,
	portgoingtocode VARCHAR(75) null,
	nameandaddofshipowners VARCHAR(75) null,
	clearanceheight LONG,
	showndraft LONG,
	dwt LONG,
	shipagencycode VARCHAR(75) null,
	purposecode INTEGER,
	crewnumber LONG,
	passengernumber LONG,
	quantityandtypeofcargo VARCHAR(75) null,
	otherpersons INTEGER,
	remarks VARCHAR(75) null
);

create table passenger_list (
	id LONG not null primary key,
	passengercode VARCHAR(75) null,
	documentno VARCHAR(75) null,
	fullname VARCHAR(75) null,
	statecode VARCHAR(75) null,
	birthday DATE null,
	birthplace VARCHAR(75) null,
	passporttypecode VARCHAR(75) null,
	passportno VARCHAR(75) null,
	portcheckincode VARCHAR(75) null,
	portcheckoutcode VARCHAR(75) null,
	istransit BOOLEAN,
	createdate DATE null,
	modifydate DATE null
);

create table responsebo (
	id LONG not null primary key,
	issuccess INTEGER,
	errormessage VARCHAR(75) null
);

create table result_certificate (
	ID LONG not null primary key,
	DocumentName LONG,
	DocumentYear INTEGER,
	MaritimeCode VARCHAR(75) null,
	CertificateCode VARCHAR(75) null,
	CertificateOrder INTEGER,
	CertificateNo VARCHAR(75) null,
	CertificateIssueDate DATE null,
	CertificateExpiredDate DATE null,
	ExaminationDate DATE null,
	ApprovalName VARCHAR(75) null,
	IsExamined INTEGER
);