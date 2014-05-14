package de.markiewb.netbeans.plugins.hints.ternary;

import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.Fix;
import org.netbeans.spi.editor.hints.Severity;
import org.netbeans.spi.java.hints.ErrorDescriptionFactory;
import org.netbeans.spi.java.hints.Hint;
import org.netbeans.spi.java.hints.HintContext;
import org.netbeans.spi.java.hints.TriggerPattern;
import org.openide.util.NbBundle;

/**
 *
 * @author markiewb
 */
@NbBundle.Messages({
    "DN_ToTernaryReturn=Convert to ternary return",
    "DESC_ToTernaryReturn=Converts if statement to ternary return statement. <p>For example: <tt>if ($cond) {return $a;} else {return $b;}</tt> will be transformed to <tt>return ($cond) ? $a : $b;</tt></p><p>Provided by <a href=\"https://github.com/markiewb/nb-additional-hints\">nb-additional-hints</a> plugin</p>",
    "DN_ToIfElseReturn=Convert to if/else return",
    "DESC_ToIfElseReturn=Converts ternary return statement to if/else statement. <p>For example: <tt>return ($cond) ? $a : $b;</tt> will be transformed to <tt>if ($cond) {return $a;} else {return $b;}</tt></p><p>Provided by <a href=\"https://github.com/markiewb/nb-additional-hints\">nb-additional-hints</a> plugin</p>",
    "DN_ToTernaryAssign=Convert to ternary assignment",
    "DESC_ToTernaryAssign=Converts if statement to ternary assignment statement. <p>For example: <tt>if ($cond) {$var = $a;} else {$var = $b;}</tt> will be transformed to <tt>$var = ($cond) ? $a : $b;</tt></p><p>Provided by <a href=\"https://github.com/markiewb/nb-additional-hints\">nb-additional-hints</a> plugin</p>",
    "DN_ToIfElseAssign=Convert to if/else assignment",
    "DESC_ToIfElseAssign=Converts ternary assignment statement to if/else statement. <p>For example: <tt>$var = ($cond) ? $a : $b;</tt> will be transformed to <tt>if ($cond) {$var = $a;} else {$var = $b;}</tt></p><p>Provided by <a href=\"https://github.com/markiewb/nb-additional-hints\">nb-additional-hints</a> plugin</p>",})
public class ToTernary {

    @TriggerPattern(value = "if ($cond) {return $a;} else {return $b;}")
    @Hint(displayName = "#DN_ToTernaryReturn", description = "#DESC_ToTernaryReturn", category = "suggestions", hintKind = Hint.Kind.ACTION, severity = Severity.HINT)
    @NbBundle.Messages("ERR_ToTernaryReturn=Convert to ternary return")
    public static ErrorDescription toTernaryReturn(HintContext ctx) {
        Fix fix = org.netbeans.spi.java.hints.JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_ToTernaryReturn(), ctx.getPath(), "return ($cond)?$a:$b;");
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_ToTernaryReturn(), fix);
    }

    @TriggerPattern(value = "return ($cond)?$a:$b;")
    @Hint(displayName = "#DN_ToIfElseReturn", description = "#DESC_ToIfElseReturn", category = "suggestions", hintKind = Hint.Kind.ACTION, severity = Severity.HINT)
    @NbBundle.Messages("ERR_ToIfElseReturn=Convert to if/else return")
    public static ErrorDescription toIfElseReturn(HintContext ctx) {
        Fix fix = org.netbeans.spi.java.hints.JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_ToIfElseReturn(), ctx.getPath(), "if ($cond) {return $a;} else {return $b;}");
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_ToIfElseReturn(), fix);
    }

    @TriggerPattern(value = "if ($cond) {$var = $a;}else {$var = $b;}")
    @Hint(displayName = "#DN_ToTernaryAssign", description = "#DESC_ToTernaryAssign", category = "suggestions", hintKind = Hint.Kind.ACTION, severity = Severity.HINT)
    @NbBundle.Messages("ERR_ToTernaryAssign=Convert to ternary assignment")
    public static ErrorDescription toTernaryAssign(HintContext ctx) {
        Fix fix = org.netbeans.spi.java.hints.JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_ToTernaryAssign(), ctx.getPath(), "$var=($cond)?$a:$b;");
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_ToTernaryAssign(), fix);
    }

    @TriggerPattern(value = "$var=($cond)?$a:$b;")
    @Hint(displayName = "#DN_ToIfElseAssign", description = "#DESC_ToIfElseAssign", category = "suggestions", hintKind = Hint.Kind.ACTION, severity = Severity.HINT)
    @NbBundle.Messages("ERR_ToIfElseAssign=Convert to if/else assignment")
    public static ErrorDescription toIfElseAssign(HintContext ctx) {
        Fix fix = org.netbeans.spi.java.hints.JavaFixUtilities.rewriteFix(ctx, Bundle.ERR_ToIfElseAssign(), ctx.getPath(), "if ($cond) {$var = $a;}else {$var = $b;}");
        return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.ERR_ToIfElseAssign(), fix);
    }
}
