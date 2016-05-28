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

            Assert.AreEqual (0, DateTime.Today.GetAge (DateTime.Today));
            Assert.AreEqual (0, DateTime.Now.GetAge (DateTime.Now));
            Assert.AreEqual (0, DateTime.Today.GetAge (DateTime.Now));
            Assert.AreEqual (0, DateTime.Now.GetAge (DateTime.Today));
        }

        [TestMethod]
        public void TestAgesByHardDate ()
        {
            var bd = new DateTime (1979, 9, 22);

            Assert.AreEqual (0, bd.GetAge (bd));
            Assert.AreEqual (0, bd.GetAge (new DateTime (1979, 12, 23)));
            Assert.AreEqual (-1, bd.GetAge (new DateTime (1979, 9, 13)));
            Assert.AreEqual (1, bd.GetAge (new DateTime (1980, 9, 23)));
            Assert.AreEqual (5, bd.GetAge (new DateTime (1984, 11, 2)));
            Assert.AreEqual (6, bd.GetAge (new DateTime (1985, 12, 22)));
            Assert.AreEqual (12, bd.GetAge (new DateTime (1991, 10, 14)));
            Assert.AreEqual (14, bd.GetAge (new DateTime (1994, 6, 29)));
            Assert.AreEqual (100, bd.GetAge (new DateTime (2079, 10, 29)));
        }

        [TestMethod]
        public void TestAgesByAddDates ()
        {
            var now = DateTime.Today;

            Assert.AreEqual (0, now.GetAge (now.AddYears (0)));
            Assert.AreEqual (0, now.GetAge (now.AddDays (10)));
            Assert.AreEqual (-1, now.GetAge (now.AddDays (-10)));

            Assert.AreEqual (1, now.GetAge (now.AddYears (1)));
            Assert.AreEqual (5, now.GetAge (now.AddYears (5).AddMonths (2)));
            Assert.AreEqual (12, now.GetAge (now.AddYears (12).AddMonths (6).AddDays (10)));
            Assert.AreEqual (14, now.GetAge (now.AddYears (14)));
            Assert.AreEqual (200, now.GetAge (now.AddYears (200).AddDays(20)));
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
