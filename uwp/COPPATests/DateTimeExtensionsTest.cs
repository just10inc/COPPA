using Microsoft.VisualStudio.TestPlatform.UnitTestFramework;
using System;

namespace Just10
{
    [TestClass]
    public class DateTimeExtensionsTest
    {
        [TestMethod]
        public void MakeEpochFromMillis ()
        {
            var dt = DateTimeExtensions.FromMillis (0);
            Assert.AreEqual (1970, dt.Year);
            Assert.AreEqual (1, dt.Month);
            Assert.AreEqual (1, dt.Day);
            Assert.AreEqual (0, dt.Hour);
            Assert.AreEqual (0, dt.Minute);
            Assert.AreEqual (0, dt.Second);
            Assert.AreEqual (0, dt.Millisecond);
        }

        [TestMethod]
        public void MakeNowFromMillis ()
        {
            var now = DateTime.Now;
            AssertDatesEqualEnough (now, DateTimeExtensions.FromMillis (now.AsMilliseconds ()));
        }

        [TestMethod]
        public void MakeTodayFromMillis ()
        {
            var now = DateTime.Today;
            AssertDatesEqualEnough (now, DateTimeExtensions.FromMillis (now.AsMilliseconds ()));
        }

        [TestMethod]
        public void MakePastDateFromMillis ()
        {
            var now = new DateTime (1979, 09, 22);
            AssertDatesEqualEnough (now, DateTimeExtensions.FromMillis (now.AsMilliseconds ()));
        }

        [TestMethod]
        public void MakeFutureDateFromMillis ()
        {
            var now = new DateTime (2179, 08, 12);
            AssertDatesEqualEnough (now, DateTimeExtensions.FromMillis (now.AsMilliseconds ()));
        }

        [TestMethod]
        public void TestTodayZeroAge ()
        {
            Assert.AreEqual (0, DateTime.Today.GetAge ());
            Assert.AreEqual (0, DateTime.Now.GetAge ());
        }

        [TestMethod]
        public void TestAgesByAddDates ()
        {
            var today = DateTime.Now;
            Assert.AreEqual (0, today.AddMonths(-3).AddDays(1).GetAge ());
            Assert.AreEqual (0, today.AddYears(0).GetAge ());
            Assert.AreEqual (0, today.AddDays (-10).GetAge ());
            Assert.AreEqual (-1, today.AddDays (10).GetAge ());
            Assert.AreEqual (1, today.AddYears (-1).GetAge ());
            Assert.AreEqual (4, today.AddYears (-5).AddDays (1).GetAge ());
            Assert.AreEqual (5, today.AddYears (-5).GetAge ());
            Assert.AreEqual (5, today.AddYears (-5).AddMonths (-2).GetAge ());
            Assert.AreEqual (12, today.AddYears (-12).AddMonths (-6).AddDays (-10).GetAge ());
            Assert.AreEqual (12, today.AddYears (-12).AddMonths (-6).AddDays (10).GetAge ());
            Assert.AreEqual (13, today.AddYears (-14).AddDays(1).GetAge ());
            Assert.AreEqual (14, today.AddYears (-14).GetAge ());
            Assert.AreEqual (200, today.AddYears (-200).AddDays (-20).GetAge ());
        }

        [TestMethod]
        public void TestFromString ()
        {
            AssertDatesEqualEnough (new DateTime (1979, 9, 22), DateTimeExtensions.FromString ("19790922"));
            AssertDatesEqualEnough (new DateTime (2016, 5, 27), DateTimeExtensions.FromString ("20160527"));
        }

        [TestMethod]
        public void TestNullFromStringThrows ()
        {
            Assert.ThrowsException<ArgumentNullException> (() => {
                DateTimeExtensions.FromString (null);
            });
        }

        [TestMethod]
        public void TestMissingYearFromStringThrows ()
        {
            Assert.ThrowsException<ArgumentException> (() => {
                DateTimeExtensions.FromString ("0922");
            });
        }

        [TestMethod]
        public void TestShortLengthFromStringThrows ()
        {
            Assert.ThrowsException<ArgumentException> (() => {
                DateTimeExtensions.FromString ("440922");
            });
        }

        [TestMethod]
        public void TestLongLengthFromStringThrows ()
        {
            Assert.ThrowsException<ArgumentException> (() => {
                DateTimeExtensions.FromString ("3332234440922");
            });
        }

        [TestMethod]
        public void TestNonNumbericFromStringThrows ()
        {
            Assert.ThrowsException<FormatException> (() => {
                DateTimeExtensions.FromString ("9x87654c");
            });
        }

        [TestMethod]
        public void TestNonNumbericYearFromStringThrows ()
        {
            Assert.ThrowsException<FormatException> (() => {
                DateTimeExtensions.FromString ("yyyy0523");
            });
        }

        [TestMethod]
        public void TestNonNumbericMonthFromStringThrows ()
        {
            Assert.ThrowsException<FormatException> (() => {
                DateTimeExtensions.FromString ("2000m923");
            });
        }

        [TestMethod]
        public void TestNonNumbericDayFromStringThrows ()
        {
            Assert.ThrowsException<FormatException> (() => {
                DateTimeExtensions.FromString ("2000092x");
            });
        }

        private void AssertDatesEqualEnough (DateTime expected, DateTime actual)
        {
            Assert.AreEqual (expected.Year, actual.Year);
            Assert.AreEqual (expected.Month, actual.Month);
            Assert.AreEqual (expected.Day, actual.Day);
            Assert.AreEqual (expected.Hour, actual.Hour);
            Assert.AreEqual (expected.Minute, actual.Minute);
            Assert.AreEqual (expected.Second, actual.Second);
            Assert.AreEqual (expected.Millisecond, actual.Millisecond);
        }
        
    }
}
