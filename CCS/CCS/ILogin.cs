﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CCS
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ILogin" in both code and config file together.
    [ServiceContract]
    public interface ILogin
    {
        [OperationContract]
        void DoWork();

        [OperationContract]
        bool DoLogin(string username, string password);

        [OperationContract]
        void CreateAccount();
    }
}
