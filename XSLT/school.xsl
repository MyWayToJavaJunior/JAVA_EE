<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : albums.xsl
    Created on : 11 Ноябрь 2015 г., 15:40
    Author     : user
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    
    <xsl:template match="/">
        <html>
            <head>
                <title>School has <xsl:value-of select="count(/school/class)"/> classes </title>
            </head>
            <body>
                <h1>School has <xsl:value-of select="count(/school/class)"/> classes </h1>
                
                <xsl:for-each select="/school/class">
                    <h2>
                        <xsl:value-of select="position()"/>)
                        <xsl:value-of select="name"/>
                        (<xsl:value-of select="count(students/student)"/> students)
                    </h2>
                    <xsl:call-template name="classTable"/>       
                </xsl:for-each>
                
            </body>
        </html>
    </xsl:template>
    
    
    
    <xsl:template name="classTable">
        <table border="1">
            <thead>
                <th>#</th>
                <th>ФИО</th>
                <th>Оценки</th>
            </thead>
            <tbody>
                <xsl:for-each select="students/student">
                    <xsl:call-template name="studentRow">
                        <xsl:with-param name="num" select="position()"/>
                    </xsl:call-template>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>
    
    <xsl:template name="studentRow">
        <xsl:param name="num"/>
        <tr>
            <td>
                <xsl:value-of select="$num"/>
            </td>
            <td>
                <xsl:value-of select="fio"/>
            </td>
            <td>
                <xsl:for-each select="subjects/subject">
                    
                        <xsl:value-of select="name"/>:
                        <xsl:for-each select="marks/mark">
                            <span style="margin: 3px;">
                                <xsl:value-of select="."/>
                            </span>
                        </xsl:for-each>
                    <br/>
                </xsl:for-each>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
