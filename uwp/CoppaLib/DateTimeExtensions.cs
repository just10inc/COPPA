using System;

namespace Just10
{
    public static class DateTimeExtensions
    {
        public static readonly DateTime EPOCH = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
        private static readonly string DATE_STRING_FORMAT = "yyyymmdd";

        public static DateTime FromMillis (long millis)
        {
            return EPOCH.AddMilliseconds(millis);
        }

        public static DateTime FromString (string yyyymmdd)
        {
            if (string.IsNullOrEmpty (yyyymmdd))
                throw new ArgumentNullException ("yyyymmdd");

            if (yyyymmdd.Length != DATE_STRING_FORMAT.Length)
                throw new ArgumentException ($"Invalid argument length ({yyyymmdd.Length}). Expected: {DATE_STRING_FORMAT.Length}.");

            return new DateTime (
                Convert.ToInt32 (yyyymmdd.Substring (0, 4)),
                Convert.ToInt32 (yyyymmdd.Substring (4, 2)),
                Convert.ToInt32 (yyyymmdd.Substring (6, 2))
                );
        }

        public static int GetAge (this DateTime birthdate, DateTime reference)
        {
            bool notReachedBDThisYear = (birthdate.Month > reference.Month || (birthdate.Month == reference.Month && birthdate.Day > reference.Day));
            return reference.Year - birthdate.Year - (notReachedBDThisYear ? 1 : 0);
        }

        public static int GetAge (this DateTime birthdate)
        {
            return birthdate.GetAge(DateTime.Today);
        }

        public static long AsMilliseconds (this DateTime value)
        {
            return (value.Ticks - EPOCH.Ticks) / 10000;
        }
    }
}
