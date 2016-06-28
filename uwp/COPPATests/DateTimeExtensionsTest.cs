/**
 Copyright 2016 Just10 Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
 
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
