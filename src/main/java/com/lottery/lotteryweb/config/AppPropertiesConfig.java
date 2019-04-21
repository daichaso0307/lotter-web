package com.lottery.lotteryweb.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppPropertiesConfig {

    @Value("${app.host-url}") private String appHostUrl;

    @Value("${app.mail.from-no-reply}") private String fromNoReply;

    @Value("${app.mail.admin}") private String adminMail;

    @Value("${app.mail.billing}") private String billingMail;

    @Value("${app.mail.batch}") private String batchMail;

    @Value("${app.mail.subject.pre-registration}") private String preRegistrationSubject;

    @Value("${app.mail.subject.registration.confirmation}")
    private String registrationConfirmationSubject;

    @Value("${app.mail.subject.registration.completion}")
    private String registrationCompletionSubject;

    @Value("${app.mail.subject.password.change}") private String passwordChangedSubject;

    @Value("${app.mail.subject.password.change-confirmation}")
    private String passwordChangeConfirmationSubject;

    @Value("${app.mail.subject.fan-board.report}") private String fanBoardReportSubject;

    @Value("${app.mail.subject.user.change-email}") private String changeEmailSubject;

    @Value("${app.mail.subject.user.change-email-confirmation}")
    private String changeEmailConfirmationSubject;

    @Value("${app.mail.subject.user.bank-account-info-change}")
    private String changeBankAccountInfoSubject;

    @Value("${app.mail.subject.user.release-notification}")
    private String releaseNotificationSubject;

    @Value("${app.mail.subject.user.withdrawal}") private String userWithdrawalSubject;

    @Value("${app.mail.subject.club.withdrawal}") private String clubWithdrawalSubject;

    @Value("${app.mail.subject.club.creation}") private String clubCreationSubject;

    @Value("${app.mail.subject.club.subscription}") private String clubSubscriptionSubject;

    @Value("${app.mail.subject.club.deletion-notification}")
    private String clubDeletionNotificationSubject;

    @Value("${app.mail.subject.club.deletion-success}")
    private String clubDeletionSuccessSubject;

    @Value("${app.mail.subject.club.free-member-as-payment-failed}")
    private String clubFreeMemberAsPaymentFailedSubject;

    @Value("${app.mail.subject.club.withdrawal-as-payment-failed}")
    private String clubWithdrawalAsPaymentFailedSubject;

    @Value("${app.mail.subject.club.fee-change}") private String clubFeeChangeSubject;

    @Value("${app.mail.subject.admin.payment-cancellation-failure}")
    private String paymentCancellationFailureSubject;

    @Value("${app.mail.subject.admin.payment-downgrade-failure}")
    private String paymentDowngradeFailureSubject;

    @Value("${app.mail.subject.admin.payment-failure}")
    private String paymentFailureSubject;

    @Value("${app.mail.subject.analytics.save-daily-clubs}")
    private String saveDailyClubSubject;

    @Value("${app.mail.subject.analytics.save-daily-club-members}")
    private String saveDailyClubMemberSubject;

    @Value("${app.mail.subject.analytics.save-daily-club-actions}")
    private String saveDailyClubActionSubject;

    @Value("${app.mail.subject.analytics.save-daily-leave-users}")
    private String saveDailyLeaveUserSubject;
}
