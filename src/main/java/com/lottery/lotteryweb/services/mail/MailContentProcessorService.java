package com.lottery.lotteryweb.services.mail;

import com.lottery.lotteryweb.common.enums.BatchType;
import com.lottery.lotteryweb.common.utils.DateUtils;
import com.lottery.lotteryweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MailContentProcessorService {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentProcessorService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    String registrationConfirmationBuilder(final String url, final String userName) {
        return templateEngine.process(
                "mail/registrationConfirmation", userAndUrlContext(userName, url)
        );
    }

    String changeEmailConfirmationBuilder(final String url, final String userName) {
        return templateEngine.process(
                "mail/changeEmailConfirmation", userAndUrlContext(userName, url)
        );
    }

    String changeEmailSuccessBuilder(final String userName) {
        return templateEngine.process("mail/changeEmailSuccess", userContext(userName));
    }

    String preRegistrationConfirmationBuilder(
            String userName,
            String userKey,
            String userAttribute,
            String createdAt) {

        Context context = userContext(userName);
        context.setVariable("userKey", userKey);
        context.setVariable("userAttribute", userAttribute);
        context.setVariable("createdAt", createdAt);
        return templateEngine.process("mail/preRegistrationConfirmation", context);
    }

    String fanboardReportToUserBuilder(final String comment, final int reason) {

        Context context = thymeleafContext();
        context.setVariable("comment", comment);
        context.setVariable("reason", reason);
        return templateEngine.process("mail/fanboardReportToUser", context);
    }

    String fanboardReportToMemmaBuilder(final String comment, final int reason) {

        Context context = thymeleafContext();
        context.setVariable("comment", comment);
        context.setVariable("reason", reason);
        return templateEngine.process("mail/fanboardReportToMemma", context);
    }

    String clubWithdrawalSuccessBuilder(final String userName, final String clubName) {
        return templateEngine.process(
                "mail/clubWithdrawalSuccess", userAndClubContext(userName, clubName)
        );
    }

    String clubCreationSuccessBuilder(
            final String userName, final String clubName, final String clubKey) {

        Context context = userAndClubContext(userName, clubName);
        context.setVariable("clubKey", clubKey);
        return templateEngine.process("mail/clubCreationSuccess", context);
    }

    String clubSubscriptionSuccessBuilder(
            final String userName,
            final String clubName,
            final Integer feeUnits,
            final String memberTypeDescription,
            final String nextBillAt) {

        Context context = userAndClubContext(userName, clubName);
        context.setVariable("feeUnits", feeUnits);
        context.setVariable("memberTypeDescription", memberTypeDescription);
        context.setVariable("nextBillAt", nextBillAt);
        return templateEngine.process("mail/clubSubscriptionSuccess", context);
    }

    String changeBankAccountInfoSuccess(final String userName) {
        return templateEngine.process(
                "mail/changeBankAccountInfoSuccess", userContext(userName)
        );
    }

    String clubDeletionNotificationBuilder(
            final String userName,
            final String clubName,
            final String applyAt) {

        Context context = userAndClubContext(userName, clubName);
        context.setVariable("applyAt", applyAt);
        return templateEngine.process("mail/clubDeletionNotification", context);
    }

    String changePasswordSuccessBuilder(final String userName) {
        return templateEngine.process(
                "mail/changePasswordSuccess", userContext(userName)
        );
    }

    String resetPasswordConfirmationBuilder(final String userName, final String url) {
        return templateEngine.process(
                "mail/resetPasswordRequest", userAndUrlContext(userName, url)
        );
    }

    String registrationSuccessBuilder(final String userKey, final String userName) {

        Context context = userContext(userName);
        context.setVariable("userKey", userKey);
        return templateEngine.process("mail/registrationSuccess", context);
    }

    String userWithdrawalSuccessBuilder(final String userName) {
        return templateEngine.process(
                "mail/userWithdrawalSuccess", userContext(userName)
        );
    }

    String clubWithdrawalAsPaymentFailedBuilder(final String userName, final String clubName) {
        return templateEngine.process(
                "mail/clubWithdrawalAsPaymentFailed", userAndClubContext(userName, clubName)
        );
    }

    String clubFreeMemberAsPaymentFailedBuilder(final String userName, final String clubName) {
        return templateEngine.process(
                "mail/clubFreeMemberAsPaymentFailed", userAndClubContext(userName, clubName)
        );
    }

    String saveDailyDataResultBuilder(
            final Optional<User> user,
            final BatchType batchType,
            final String batchMail,
            final List successList,
            final List failureList,
            final LocalDateTime targetDatetime,
            final String targetHost,
            final int successCount,
            final int failureCount,
            final LocalDateTime startDate,
            final LocalDateTime endDate) {


        Context context = new Context();
        context.setVariable("executor", user.get().getEmail());
        context.setVariable("batchName", batchType.getLabel());
        context.setVariable("targetTable", batchType.getTableName());
        context.setVariable("batchMail", batchMail);
        context.setVariable("successList", successList);
        context.setVariable("failureList", failureList);
        context.setVariable("targetDatetime", DateUtils.getTargetDateToString(targetDatetime));
        context.setVariable("targetHost", targetHost);
        context.setVariable("successCount", successCount);
        context.setVariable("failureCount", failureCount);
        context.setVariable("startDate", startDate);
        context.setVariable("endDate", endDate);
        return templateEngine.process("mail/saveDailyDataResult", context);
    }

    String clubFeeDowngradeSuccessBuilder(
            final String userName,
            final String clubName,
            final Integer currentFeeUnits,
            final Integer nextFeeUnits,
            final String memberTypeDescription,
            final String nextBillAt) {

        Context context = userAndClubContext(userName, clubName);
        context.setVariable("downgradedFeeUnits", nextFeeUnits - currentFeeUnits);
        context.setVariable("nextFeeUnits", nextFeeUnits);
        context.setVariable("memberTypeDescription", memberTypeDescription);
        context.setVariable("nextBillAt", nextBillAt);
        return templateEngine.process("mail/clubFeeDowngradeSuccess", context);
    }

    String clubFeeUpgradeSuccessBuilder(
            final String userName,
            final String clubName,
            final Integer currentFeeUnits,
            final Integer nextFeeUnits,
            final String memberTypeDescription,
            final String nextBillAt) {

        Context context = userAndClubContext(userName, clubName);
        context.setVariable("upgradedFeeUnits", nextFeeUnits - currentFeeUnits);
        context.setVariable("nextFeeUnits", nextFeeUnits);
        context.setVariable("memberTypeDescription", memberTypeDescription);
        context.setVariable("nextBillAt", nextBillAt);
        return templateEngine.process("mail/clubFeeUpgradeSuccess", context);
    }

    String sendPaymentCancellationFailureBuilder(final List<String>  targets) {
        Context context = new Context();
        context.setVariable("targets", targets);
        return templateEngine.process("mail/paymentCancellationFailure", context);
    }

    String sendPaymentDowngradeFailureBuilder(final List<String> targets) {
        Context context = new Context();
        context.setVariable("targets", targets);
        return templateEngine.process("mail/paymentDowngradeFailure", context);
    }

    String sendPaymentFailureBuilder(final List<String> targets) {
        Context context = new Context();
        context.setVariable("targets", targets);
        return templateEngine.process("mail/paymentFailure", context);
    }

    String releaseNotificationBuilder(
            final User user,
            final String password,
            final String releaseOne,
            final String releaseTwo,
            final String releaseThree,
            final String releaseProcedure) {
        Context context = thymeleafContext();
        context.setVariable("userName", user.getUserName());
        context.setVariable("passId", user.getPassId());
        context.setVariable("password", password);
        context.setVariable("releaseOne", releaseOne);
        context.setVariable("releaseTwo", releaseTwo);
        context.setVariable("releaseThree", releaseThree);
        context.setVariable("releaseProcedure", releaseProcedure);

        return templateEngine.process("mail/releaseNotification", context);
    }

    private Context thymeleafContext() {
        Context context = new Context();
        context.setVariable("year", DateUtils.getCurrentYear());
        return context;
    }

    private Context userContext(final String userName) {
        Context context = thymeleafContext();
        context.setVariable("userName", userName);
        return context;
    }

    private Context userAndClubContext(final String userName, final String clubName) {
        Context context = thymeleafContext();
        context.setVariable("userName", userName);
        context.setVariable("clubName", clubName);
        return context;
    }

    private Context userAndUrlContext(final String userName, final String url) {
        Context context = thymeleafContext();
        context.setVariable("userName", userName);
        context.setVariable("url", url);
        return context;
    }
}
