using System;
using Microsoft.VisualStudio.TestPlatform.UnitTestFramework;

namespace Just10
{
    [TestClass]
    public class COPPATest
    {
        // AgeMeetsCOPPARequirements (DateTime birthdate)
        
        [TestMethod]
        public void TestZeroYearOldDateTimeDoesntMeetsCOPPARequirements()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements(DateTime.Now));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AddDays(-15)));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AddMonths(-5)));
        }

        [TestMethod]
        public void TestOneYearOldDateTimeDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears(-1)));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-1).AddMonths(3)));
        }

        [TestMethod]
        public void TestFiveYearOldDateTimeDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5)));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5).AddMonths (6).AddDays(4)));
        }

        [TestMethod]
        public void TestThirteenYearOldDateTimeDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13)));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13).AddMonths (7)));
        }

        [TestMethod]
        public void TestFourteenYearOldDayShortDateTimeDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays(1)));
        }

        [TestMethod]
        public void TestFourteenYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14)));
        }

        [TestMethod]
        public void TestFourteenYearOldAndADayDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays (-1)));
        }

        [TestMethod]
        public void TestFifteenYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddDays(-20)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddMonths(-4).AddDays (-20)));
        }

        [TestMethod]
        public void TestEighteenYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddDays (-7)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddMonths (-8).AddDays (-12)));
        }

        [TestMethod]
        public void TestTwentyYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddDays (-22)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddMonths (-2).AddDays (-15)));
        }

        [TestMethod]
        public void TestFiftyYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddDays (-9)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddMonths (-10).AddDays (1)));
        }

        [TestMethod]
        public void TestHundredYearOldDateTimeMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddDays (-19)));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddMonths (-3).AddDays (-21)));
        }

        // AgeMeetsCOPPARequirements (long birthdate)
        [TestMethod]
        public void TestZeroYearOldLongDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AsMilliseconds()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddDays (-15).AsMilliseconds ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AddMonths (-5).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestOneYearOldLongDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-1).AsMilliseconds()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-1).AddMonths (3).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestFiveYearOldLongDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5).AsMilliseconds()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5).AddMonths (6).AddDays (4).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestThirteenYearOldLongDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13).AsMilliseconds()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13).AddMonths (7).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestFourteenYearOldDayShortLongDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays (1).AsMilliseconds()));
        }

        [TestMethod]
        public void TestFourteenYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AsMilliseconds()));
        }

        [TestMethod]
        public void TestFourteenYearOldAndADayLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays (-1).AsMilliseconds()));
        }

        [TestMethod]
        public void TestFifteenYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AsMilliseconds()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddDays (-20).AsMilliseconds ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddMonths (-4).AddDays (-20).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestEighteenYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AsMilliseconds()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddDays (-7).AsMilliseconds ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddMonths (-8).AddDays (-12).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestTwentyYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AsMilliseconds()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddDays (-22).AsMilliseconds ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddMonths (-2).AddDays (-15).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestFiftyYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AsMilliseconds()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddDays (-9).AsMilliseconds ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddMonths (-10).AddDays (1).AsMilliseconds ()));
        }

        [TestMethod]
        public void TestHundredYearOldLongDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AsMilliseconds()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddDays (-19).AsMilliseconds ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddMonths (-3).AddDays (-21).AsMilliseconds ()));
        }

        // AgeMeetsCOPPARequirements (string yyyymmdd)
        [TestMethod]
        public void TestZeroYearOldStringDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AsYYYYMMDD ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddDays (-15).AsYYYYMMDD ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Now.AddMonths (-5).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestOneYearOldStringDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-1).AsYYYYMMDD ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-1).AddMonths (3).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFiveYearOldStringDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5).AsYYYYMMDD ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-5).AddMonths (6).AddDays (4).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestThirteenYearOldStringDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13).AsYYYYMMDD ()));
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-13).AddMonths (7).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements ()
        {
            Assert.IsFalse (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays (1).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFourteenYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFourteenYearOldAndADayStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-14).AddDays (-1).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFifteenYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddDays (-20).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-15).AddMonths (-4).AddDays (-20).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestEighteenYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddDays (-7).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-18).AddMonths (-8).AddDays (-12).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestTwentyYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddDays (-22).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-20).AddMonths (-2).AddDays (-15).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestFiftyYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddDays (-9).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-50).AddMonths (-10).AddDays (1).AsYYYYMMDD ()));
        }

        [TestMethod]
        public void TestHundredYearOldStringDateMeetsCOPPARequirements ()
        {
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddDays (-19).AsYYYYMMDD ()));
            Assert.IsTrue (COPPA.AgeMeetsCOPPARequirements (DateTime.Today.AddYears (-100).AddMonths (-3).AddDays (-21).AsYYYYMMDD ()));
        }
    }
}
