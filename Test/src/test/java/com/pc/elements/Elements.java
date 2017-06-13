package com.pc.elements;

import java.util.HashMap;
import org.openqa.selenium.By;

public class Elements
{
		private  HashMap<String,By> hm = new HashMap<String,By>();  
		
		public Elements()
		{	
			//LogIn Objects
			hm.put("edtUserName", By.id("Login:LoginScreen:LoginDV:username-inputEl"));
			hm.put("pwdPassword", By.id("Login:LoginScreen:LoginDV:password-inputEl"));  
			hm.put("btnLogin", By.id("Login:LoginScreen:LoginDV:submit-btnInnerEl"));
			
			//Objects under Action Menu which is Under Desktop Main Menu
			hm.put("eleDeskTopAction", By.id("Desktop:DesktopMenuActions-btnInnerEl"));
			hm.put("eleDeskTopNewAccount", By.id("Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_NewAccount-textEl"));
			
			//Enter New Account Search Objects
			hm.put("edtCompanyName", By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:GlobalContactNameInputSet:Name-inputEl"));
			hm.put("eleAccountInfoSearch", By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleAccountInfoCreateNewAccount", By.id("NewAccount:NewAccountScreen:NewAccountButton-btnInnerEl"));
			hm.put("eleCreateNewAccountForPerson", By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Person-textEl"));
			
			//Create Account Objects
			hm.put("edtFirstName", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
			hm.put("edtLastName", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
			hm.put("edtAddress1", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
			hm.put("eleCity", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
			hm.put("edtCity", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
			hm.put("zedCity", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
			hm.put("lstState", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
			hm.put("eleZipCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
			hm.put("zedZipCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
			hm.put("lstZipCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
			hm.put("lstAddressType", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressType-inputEl"));
			hm.put("lstOrgType", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:OrgType-inputEl"));
			hm.put("eleOrgSearch", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:Producer:SelectOrganization"));
			hm.put("lstProducerCodeOrgType", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:Type-inputEl"));
			hm.put("edtOrganizationName", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
			hm.put("eleOrgResSearch", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleOrgSearchResults", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchLV:0:_Select"));
			hm.put("lstProducerCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode-inputEl"));
			hm.put("eleUpdate", By.cssSelector("a[id='CreateAccount:CreateAccountScreen:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
			hm.put("btnUpdate", By.id("CreateAccount:CreateAccountScreen:Update-btnInnerEl"));
			hm.put("eleStandardise", By.id("CreateAccount:CreateAccountScreen:standardizeButton_Ext-btnInnerEl"));
			hm.put("eleCreateNewAccountNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"));
			hm.put("eleNew", By.id("MatchingSearchResults_ExtWorksheet:ToolbarButton-btnEl"));
			hm.put("eleAddSuccessMsg", By.id("CreateAccount:CreateAccountScreen:_msgs"));
			
			//Edit Account
			hm.put("eleEdtButton", By.id("AccountFile_Summary:AccountFile_SummaryScreen:EditAccount-btnInnerEl"));
			hm.put("edtAIFNum", By.id("EditAccountPopup:EditAccountScreen:aifNumber_Ext-inputEl"));
			hm.put("edtAllianceNum", By.id("EditAccountPopup:EditAccountScreen:allianceNumber_Ext-inputEl"));
			hm.put("edtFEINNum", By.id("EditAccountPopup:EditAccountScreen:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
			hm.put("eleEditUpdate", By.id("EditAccountPopup:EditAccountScreen:Update-btnInnerEl"));
			hm.put("txtFEINNum", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
			hm.put("txtAllianceNum", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:allianceNumber_Ext-inputEl"));
			hm.put("txtAIFNum", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:aif_Ext-inputEl"));
			
			//Contacts
			hm.put("eleCreateNewContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnInnerEl"));
//			hm.put("elePrimaryContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:14:roleType-arrowEl"));
//			hm.put("elePrimaryNewPerson", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:14:roleType:0:contactType-textEl"));
			hm.put("elePrimaryContact", By.xpath(".//span[contains(text(), 'Primary Contact')]"));
			hm.put("elePrimaryNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
			hm.put("edtFName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
			hm.put("edtLName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
			hm.put("sclCTUpdate", By.id("NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
			hm.put("eleContactUpdate", By.id("NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
//			hm.put("eleSecondaryContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:14:roleType-arrowEl"));
//			hm.put("eleSecondaryNewPerson", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:14:roleType:1:contactType-textEl"));
//			hm.put("eleSecondaryContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:15:roleType-arrowEl"));
//			hm.put("eleSecondaryNewPerson", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:15:roleType:1:contactType-textEl"));
			hm.put("eleSecondaryContact", By.xpath(".//span[contains(text(), 'Secondary Contact')]"));
			hm.put("eleSecondaryNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
			hm.put("eleSameAddressAs", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
			hm.put("eleAccountHolder", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
			hm.put("eleAccountAddress", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress"));
			hm.put("eleAssertContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:ttlBar"));
			
			//LogOut
			hm.put("elePreferences", By.id(":TabLinkMenuButton-btnIconEl"));
			hm.put("eleLogOut", By.id("TabBar:LogoutTabBarLink-textEl"));	
		
			//melAccount	edtAccountNumbar	eleAccountSearch
			hm.put("melAccount", By.id("TabBar:AccountTab-btnInnerEl"));
			hm.put("melSearch", By.id("TabBar:SearchTab-btnInnerEl"));
			hm.put("melAdministration", By.id("TabBar:AdminTab-btnWrap"));
            hm.put("edtaccountNumber", By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"));    
            hm.put("btnAccountSearch", By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
            hm.put("eleSearchAccount", By.id("TabBar:SearchTab:Search_AccountSearch-textEl"));

			//NewSubmission 
//			hm.put("eleActions", By.id("AccountFile:AccountFileMenuActions-btnIconEl"));
			hm.put("eleActions", By.xpath(".//*[contains(@id,'MenuActions-btnInnerEl')]"));
			hm.put("eleNewSubmission", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl")); 					
			hm.put("eleOrganisationSearch", By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:Producer:SelectOrganization"));
			hm.put("edtOrganisationName", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:GlobalContactNameInputSet:Name-inputEl"));
			hm.put("eleSearchButton", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleSearchResult", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchResultsLV:0:_Select"));
			hm.put("lstProduverCodeList", By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:ProducerCode-inputEl"));
			hm.put("lstSegment", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:segment_Ext-inputEl"));
//			hm.put("eleWorkeComp", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission"));
//			hm.put("btnWorkerComp", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission"));
//			hm.put("eljWorkerComp", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission"));
			hm.put("assertforPolicyINFOPage", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:DateQuoteNeeded-labelEl"));
			hm.put("edtEffDate", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultPPEffDate_Ext-inputEl"));
			hm.put("lstBusinessGroup", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:businessGrouping_Ext-inputEl"));
			hm.put("lstSalesAgreementCode", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:SalesAgreementCode-inputEl"));
			hm.put("eljShell", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission"));
			hm.put("eljSOR", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:SystemOfRecord"));
			hm.put("eleProductNameTable", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV-body"));
			hm.put("funSelectLOB", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV-body"));
			
			//Organisation
			hm.put("eleOrganisation", By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:ttlBar"));
			
			//Next is common for all the pages
			hm.put("eleNext", By.id("SubmissionWizard:Next-btnInnerEl"));
			
			//PolicyInfo
			hm.put("elePISaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
			hm.put("edtFEIN", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:PolicyOfficialIDInputSet:OfficialIDDV_Input-inputEl"));
			hm.put("eleIndustryCodeSearch", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:IndustryCode:SelectIndustryCode"));
			hm.put("edtIndustryCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Code-inputEl"));
			hm.put("btnSearchButton", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleSelectCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchResultsLV:0:_Select"));
			hm.put("edtIndusCode", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:IndustryCode-inputEl"));
			hm.put("edtNAICS", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:NAICSIndustryCode-inputEl"));
			hm.put("edtMSI", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:MSIExt-inputEl") );
			hm.put("edtEBS", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:YearBusinessStarted-inputEl") );
			hm.put("lstOrganisationType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:OrganizationType-inputEl") );
			hm.put("lstProductType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ProductType-inputEl") );
			hm.put("lstSubmissionSource", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl") );
			hm.put("edtNPNNum", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:NPNNumber-inputEl") );
			
			//Location
			hm.put("eleLocations", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:ttlBar"));
			hm.put("eleLocSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
            hm.put("eleclkSubmissionLocation",By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationsEdit_LV:0:Address"));
            hm.put("edtLocationNumberofEmp",By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LineLocationDetailInputSet:EmployeeCount-inputEl"));
            hm.put("eleLocationStandardize", By.id("LocationPopup:LocationScreen:standardizeButton_Ext-btnInnerEl"));
            hm.put("eleLocationOK", By.id("LocationPopup:LocationScreen:updateButton_Ext-btnInnerEl"));
			
			//State Coverages
			hm.put("eleWCSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WorkersCompCoverageConfigScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
			hm.put("eleAddClass", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV_tb:Add-btnInnerEl"));
			hm.put("lstUWCompanies", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UWCompanyInputSet:UWCompany-inputEl"));
			hm.put("assertforStateCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7PolicyCoveragesDV:0"));
			hm.put("eleCoveredEmployees", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:4"));
			hm.put("eleStateCoverageLookUp", By.xpath(".//div[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV:')]"));
			hm.put("edtRiskScore", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:riskScore_Ext-inputEl"));
			
			//Supplemental
			hm.put("eleSupplemental", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WorkersCompSupplementalScreen:ttlBar"));
			
			//WC Options
			hm.put("eleAddWCOptions", By.xpath("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:CoverageOptionsScreen:WCOptionsPanelSet:OptionIteratorButton-btnInnerEl"));
			hm.put("eleWCOptSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:CoverageOptionsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
			hm.put("eleWCOpt", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:WorkersCompOptions']/div/span"));
			
			//Risk Analysis
			hm.put("eleRiskAnalysis", By.id("SubmissionWizard:Job_RiskAnalysisScreen:0"));
			hm.put("eleRASaveDraft", By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
			hm.put("eleRAQuote", By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
			hm.put("eleUWInfo", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfoTab-btnInnerEl"));
			hm.put("lstBestIndex", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:bestIndex-inputEl"));
			
			//Quote
			hm.put("sclQuote", By.xpath(".//*[@id='SubmissionWizard:SubmissionWizard_PolicyReviewScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl']"));
			hm.put("elePRQuote", By.xpath(".//*[@id='SubmissionWizard:SubmissionWizard_PolicyReviewScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl']"));
			hm.put("eleBindOption", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
			hm.put("eleIssuePolicy", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions:BindAndIssue-textEl"));
			hm.put("eleAlertPopUp", By.id("button-1005-btnInnerEl"));
			hm.put("eleDetails", By.id("UWBlockProgressIssuesPopup:IssuesScreen:DetailsButton-btnInnerEl"));
			hm.put("eleApprove", By.xpath(".//a[contains(text(), 'Approve')]"));
			hm.put("eleRiskOkButton", By.id("RiskApprovalDetailsPopup:Update-btnInnerEl"));
			hm.put("eleApproveButton", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:Approve"));
//			hm.put("eleApproveButton", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:Approve"));
			hm.put("eleSPLApprvoalAssert", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:WarningsPanelSet:0:PanelSet:Warning"));
			hm.put("eleRiskAnalysispage", By.xpath(".//span[contains(text(),'Risk Analysis')]"));
			hm.put("eleAuthorityApprove", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:authorityAcknowledge_Ext"));
			hm.put("eleBindOptionAssert", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions-btnInnerEl"));
//			hm.put("eleApprove", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:Approve"));
			hm.put("eleAuthorityAckowledge", By.xpath(".//a[contains(text(), 'Authority Acknowledge')]"));
			hm.put("eleSpecialApprove", By.xpath(".//a[contains(text(),'Special Approve')]"));
			hm.put("eleSpecialApproveButton", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:SpecialApprove"));
			
			//Payment
			hm.put("elePaymentPage", By.xpath(".//span[contains(text(),'Payment')]"));
			hm.put("lstBillingMethod", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethod-inputEl"));
			hm.put("elePayBindOption", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
			hm.put("elePayIssuePolicy", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions:BindAndIssue-textEl"));
			hm.put("elePolicyNumber", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
			hm.put("lstBillingNumber", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:billingnumber_Ext-inputEl"));
			hm.put("edtBillingNumber", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:enterBillingNumber_Ext-inputEl"));
			hm.put("lstPay", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:installmentplans_Ext-inputEl"));
			hm.put("elePolicySummary", By.id("PolicyFile_Summary:Policy_SummaryScreen:0"));
			hm.put("bliPayBindOption", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
			hm.put("eleclkPolicyNumber", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
			hm.put("eleViewPolicy", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
			hm.put("elePolicyNumbetInPolicySummaryPage", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_PolicyDV:PolicyNumber-inputEl"));
			
			//Final Submission Bound Page(To take the policy Number)
			hm.put("eleSubmissionBound", By.id("JobComplete:JobCompleteScreen:ttlBar"));
			hm.put("elePolicyNumberText", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
			hm.put("eleSubmissionNumber", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewJob-inputEl"));
			
			//Add Class Function
			hm.put("eletableRowXpath", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV-body']/div/table/tbody"));
			hm.put("eleCheckingStateActExist", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV-body']/div/table/tbody/tr"));
			
			//State Edit Box
			hm.put("edtStateAct", By.name("WC7SpecialCoverage"));
			
			//Address Edit Box
			hm.put("edtAddressCode", By.name("Loc"));
			
			//Class CodeeleAccMerge
			hm.put("lstAddClassSearchCode", By.name("ClassCode"));
			hm.put("eleAddClassSearchButton", By.className("x-trigger-index-0 x-form-trigger x-form-search-trigger x-form-trigger-first"));
			hm.put("eleClassSearchButton", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV:0:ClassCode:SelectClassCode"));
			hm.put("edtEnterClassCode", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:WC7ClassCodeSearchDV:Code-inputEl"));
			hm.put("eleClassCodeButton", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:WC7ClassCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleSelectInput", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:ClassCodeSearchResultsLV:0:_Select"));
			
			//Annaul Premium
			hm.put("eleAnualPremiumEditClick", By.name("AnnualRenum"));
			hm.put("edtAnualPremiumEditClick", By.name("AnnualRenum"));
			hm.put("lstAnualPremiumEditClick", By.name("AnnualRenum"));
			
			//Merge Accounts
			hm.put("eleAccMerge", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_MergeAccounts-textEl"));
			hm.put("edtAccNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AccountNumber-inputEl"));
			hm.put("eleMergeSearch", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleSelect", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:OtherAccountSearchResults_ExtLV:0:Select_Ext"));
			hm.put("eleMerge", By.id("AccountFile_MergeAccountsSelection:MergeAccounts-btnInnerEl"));
			hm.put("edtMergeCompanyName", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:GlobalContactNameInputSet:Name-inputEl"));
			hm.put("eleSameTgtasSrc", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:_msgs"));
			hm.put("eleMergeCancel", By.id("AccountFile_MergeAccountsSelection:CancelButton-btnInnerEl"));
			hm.put("btnResetbtn", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
			hm.put("txtMergeTranMsg", By.id("AccountFile_Summary:AccountFile_SummaryScreen:accountMergeMsg_Ext"));
			hm.put("txtMergeCancelMsg", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:GlobalContactNameInputSet:Name-labelEl"));
			hm.put("txtCapAccNum", By.xpath(".//*[@id='AccountFile:AccountFileInfoBar:Account-btnInnerEl']/span[2]"));
			hm.put("txtTagetAccNotExistMsg", By.xpath(".//*[@id='AccountFile_AccountSearch:OtherAccountSearchScreen:_msgs']/div[1]"));
			hm.put("eleContacts", By.xpath(".//span[contains(text(), 'Contacts')]"));
			hm.put("eleRole", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:RolesCardTab-btnInnerEl"));
			hm.put("eleMAHTable1", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/table/tbody/tr[2]/td[4]"));
			
			//Merge Validation
			hm.put("eleSearchMenu", By.id("TabBar:SearchTab-btnWrap"));
			hm.put("eleAccSearch", By.id("TabBar:SearchTab:Search_AccountSearch-textEl"));
			hm.put("edtSourceAccount", By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:AccountNumber-inputEl"));
			hm.put("eleZeroResultMsg", By.xpath(".//div[contains(text(), 'The search returned zero results.')]"));
			hm.put("eleMVSearch", By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
			hm.put("eleCompMatch", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:CompanyNameExact-inputEl"));
			hm.put("edtMerAllianceNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AllianceMember_Ext-inputEl"));
			hm.put("edtMerAIFNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AIFNumber_Ext-inputEl"));
			hm.put("edtMerFEIN", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:FEIN_Ext-inputEl"));
			hm.put("edtMerExperian", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:ExperianKey_Ext-inputEl"));
			hm.put("eleMAHTable2", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactRolesDV:ContactRolesLV-body']/div/table/tbody/tr/td[2]"));
			hm.put("txtCheckNewRoleActiveStatus", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/table/tbody/tr[2]/td[2]"));
			hm.put("eleMerAIFNum", By.id("EditAccountPopup:EditAccountScreen:aifNumber_Ext-inputEl"));
			hm.put("eleMerAllianceNum", By.id("EditAccountPopup:EditAccountScreen:allianceNumber_Ext-inputEl"));
			hm.put("eleMerFEINNum", By.id("EditAccountPopup:EditAccountScreen:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
			hm.put("accFileContactRoleTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));	
		}
		
		public By getObject(String ff)
		{
			By retuValue = null;
			if(hm.containsKey(ff))
			{
			  retuValue = hm.get(ff);
			}
			return retuValue;
		}
}